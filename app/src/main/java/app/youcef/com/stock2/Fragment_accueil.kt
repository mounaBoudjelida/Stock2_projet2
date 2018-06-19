package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.youcef.com.stock2.Adapters.FilmeAdapter
import  app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.DetailsFilme
import app.youcef.com.stock2.Controller.detailsSerie
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Model.Serie
import  app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import app.youcef.com.stock2.constants.ApiParam.apiKey
import app.youcef.com.stock2.remote.FilmeAPIClient
import app.youcef.com.stock2.remote.SerieAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_accueil():Fragment(){
    lateinit var adapterFilme:FilmeAdapter
    lateinit var adapterSerie:SerieAdapter
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {




        /*_____________________________________________*/


         var view= inflater!!.inflate(R.layout.fragment_accueil,container, false)
            showMovies()
            showSeries()


         /*_____________________________________________*/


         return view
    }




    fun setupRecyclerMovie(movieList: List<Filme>) {

        var recyclerView=view?.findViewById<RecyclerView>(R.id.recyclerViewFilme) as RecyclerView
        adapterFilme= FilmeAdapter(this.context,movieList){ filme ->

            val filmeIntent= Intent(this.context, DetailsFilme::class.java)
            filmeIntent.putExtra(EXTRA_FILME,filme.id)
            startActivity(filmeIntent)
        }
        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context,OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapterFilme

    }




    fun setupRecyclerSerie(serieList: List<Serie>) {

        var recyclerViewSerie=view?.findViewById<RecyclerView>(R.id.recyclerViewSerie) as RecyclerView
        adapterSerie= SerieAdapter(this.context,serieList){serie ->

            val serieIntent= Intent(this.context, detailsSerie::class.java)
            serieIntent.putExtra(EXTRA_SERIE,serie.id)
            startActivity(serieIntent)
        }
        var sLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context,OrientationHelper.HORIZONTAL,false)
        recyclerViewSerie.layoutManager=sLayoutManager
        recyclerViewSerie.adapter=adapterSerie

    }
    /*_____________________________________________________________________________________*/
    val clientFilm by lazy {
        FilmeAPIClient.create()
    }
    var disposableFilm: Disposable? = null
    private fun showMovies() {

        disposableFilm = clientFilm.getArticles(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecyclerMovie(result.results);DataService.filmes=result.results;DataService.filmesProject=result.results},
                        { error -> Log.e("ERROR", error.message) }
                )

    }
    /*__________________ Les series en cours de projection _________________*/
    val clientSerie by lazy {
        SerieAPIClient.create()
    }
    var disposableSerie: Disposable? = null
    private fun showSeries() {

        disposableSerie = clientSerie.getSeries(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecyclerSerie(result.results)
                            Log.v("rani f serie", "" + result.results)
                            DataService.seriesEnCoursDeProjection=result.results;},
                        { error -> Log.e("ERROR", error.message) }
                )

    }


}