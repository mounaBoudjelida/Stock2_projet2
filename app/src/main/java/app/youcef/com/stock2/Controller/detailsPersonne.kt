package app.youcef.com.stock2.Controller

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import app.youcef.com.stock2.Adapters.FilmeAdapter
import app.youcef.com.stock2.Model.*
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_PERSONNE
import app.youcef.com.stock2.Constants.ApiParam
import app.youcef.com.stock2.APIs.ActeurAPIClient
import app.youcef.com.stock2.AppDB
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details_personne.*
import kotlinx.android.synthetic.main.fragment_filme.*

class detailsPersonne : AppCompatActivity() {
    lateinit var adapter: FilmeAdapter
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_personne)





        val personneIndex=findPersonne(intent.getIntExtra(EXTRA_PERSONNE,0))

        Glide.with(this).load(DataService.personnes[personneIndex].getImage()).into(imageDetails)
        getDetails(intent.getIntExtra(EXTRA_PERSONNE,0)).subscribe(

                {result->
                    Log.v("hi in details personne ", "" + intent.getIntExtra(EXTRA_PERSONNE,0))

                        if(result.biography==""){
                            biographieContent?.text="Aucune information n'a été reçue depuis l'API"
                        }
                        else{biographieContent?.text=result.biography}
                        if(result.birthday==null){dateNaissance?.text="00-00-0000"}
                        else{dateNaissance?.text=result.birthday}
                        textViewDetails?.text=DataService.personnes[personneIndex].name

                    showFilmographie(intent.getIntExtra(EXTRA_PERSONNE,0))

                },
                {error-> Log.e("ERROR in det per", error.message)
                    biographieContent?.text="Aucune information n'a été reçue depuis l'API"
                    dateNaissance?.text="Aucune information deouis l'API"

                }


        )
        showFilmographie(intent.getIntExtra(EXTRA_PERSONNE,0))
    }


    val client by lazy {
        ActeurAPIClient.create()
    }
    var disposableActeur: Disposable? = null
    private fun getDetails(id:Int): Observable<DetailsPersonne> {

        return client.getDetails(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    }

    fun setupRecyclerFilmographie(filmographie: List<Filme>) {

        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewFilmographie) as RecyclerView
        adapter= FilmeAdapter(this,filmographie){filme ->

            val filmeIntent= Intent(this, DetailsFilme::class.java)
            filmeIntent.putExtra(EXTRA_FILME,filme.id)
            startActivity(filmeIntent)
        }

        var mLayoutManager: RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter

    }



    private fun showFilmographie(id:Int) {
        var listFilm: MutableList<Filme> = arrayListOf()

        var p: Personne =DataService.personnes[findPersonne(id)]
        p.known_for!!.forEach {
            listFilm.add(Filme(it.id, it.vote_count,it.video,it.vote_average,
                    it.title,it.popularity,it.poster_path,it.original_language,it.original_title,
                    it.backdrop_path,it.adult,it.overview))
        }
        setupRecyclerFilmographie(listFilm)



    }






    fun findPersonne(id:Int):Int{
        var bool=true
        var i=0
        while(bool==true && i<DataService.personnes.size){
            if(DataService.personnes[i].id==id){ bool=false ;}
            i++
        }
        return i-1

    }
}