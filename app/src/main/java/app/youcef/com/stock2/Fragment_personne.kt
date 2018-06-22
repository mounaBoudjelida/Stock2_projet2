package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  app.youcef.com.stock2.Adapters.PersonneRecycleAdapter
import  app.youcef.com.stock2.Controller.detailsPersonne
import  app.youcef.com.stock2.Model.Personne
import  app.youcef.com.stock2.Services.DataService
import  app.youcef.com.stock2.Utilities.EXTRA_PERSONNE
import app.youcef.com.stock2.Constants.ApiParam
import app.youcef.com.stock2.APIs.ActeurAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by hp on 17/04/2018.
 */
class Fragment_personne: Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view= inflater!!.inflate(R.layout.fragment_personne, container, false)

        showActeurs()

        return view

    }

    fun setupRecyclerActeur(ActeurList: List<Personne>) {

        var recyclerView=view?.findViewById<RecyclerView>(R.id.personnesListView) as RecyclerView
        var personneAdapter= PersonneRecycleAdapter(this.context,ActeurList){personne ->

            val personneIntent=Intent(this.context,detailsPersonne::class.java)
            personneIntent.putExtra(EXTRA_PERSONNE,personne.id)
            startActivity(personneIntent)

        }
        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=personneAdapter

    }
    /*_____________________________________________________________________________________*/
    val clientActeurs by lazy {
        ActeurAPIClient.create()
    }
    var disposableActeur: Disposable? = null
    private fun showActeurs() {

        disposableActeur = clientActeurs.getLesActeurs(ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecyclerActeur(result.results);DataService.personnes=result.results},
                        { error -> Log.e("ERROR", error.message) }
                )

    }






}