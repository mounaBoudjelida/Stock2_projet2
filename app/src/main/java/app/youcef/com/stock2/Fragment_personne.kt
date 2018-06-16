package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import  app.youcef.com.stock2.Adapters.PersonneAdapter
import  app.youcef.com.stock2.Adapters.PersonneRecycleAdapter
import  app.youcef.com.stock2.Controller.detailsPersonne
import  app.youcef.com.stock2.Model.Personne
import  app.youcef.com.stock2.Services.DataService
import  app.youcef.com.stock2.Utilities.EXTRA_PERSONNE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_personne.*

/**
 * Created by hp on 17/04/2018.
 */
class Fragment_personne: Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view= inflater!!.inflate(R.layout.fragment_personne, container, false)
        var recyclerView=view.findViewById<RecyclerView>(R.id.personnesListView) as RecyclerView
        var personneAdapter= PersonneRecycleAdapter(this.context,DataService.personnes){personne ->
            println(personne.nomPrenom)
            val personneIntent=Intent(this.context,detailsPersonne::class.java)
            personneIntent.putExtra(EXTRA_PERSONNE,DataService.personnes.indexOf(personne))
            startActivity(personneIntent)

        }
        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=personneAdapter


        return view

    }
}