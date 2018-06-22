package app.youcef.com.stock2

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.detailsSerie
import app.youcef.com.stock2.Model.Serie
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import app.youcef.com.stock2.Constants.ApiParam.apiKey
import app.youcef.com.stock2.APIs.SerieAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_serie.*


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_serie:Fragment(){
    lateinit var adapter:SerieAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view= inflater!!.inflate(R.layout.fragment_serie, container, false)
        showSeries()
        return view
    }



    /*__________________Pour la recherche __________________________*/
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchSerie.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {

                var recyclerView=view!!.findViewById<RecyclerView>(R.id.serieGridView) as RecyclerView
                //adapter= FilmeAdapter(context,DataService.mesFilmes)


                if(newText.isNullOrBlank() == true  ){
                    adapter = SerieAdapter(context,DataService.seriesAprendreDetails){serie ->
                        println(serie.name)
                        val serieIntent= Intent(context, detailsSerie::class.java)
                        serieIntent.putExtra(EXTRA_SERIE,serie.id)
                        startActivity(serieIntent)
                    }
                }else {
                    if(newText != null){
                        val modelfiltre  = filter(newText,DataService.seriesAprendreDetails)
                        adapter= SerieAdapter(context,modelfiltre){serie ->
                            println(serie.name)
                            val serieIntent= Intent(context, detailsSerie::class.java)
                            serieIntent.putExtra(EXTRA_SERIE,serie.id)
                            startActivity(serieIntent)
                        }
                    }
                }

                recyclerView.adapter=adapter

                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }
        })
    }

    private fun filter(query:String,newList:List<Serie>):List<Serie>{
        val filteredList = ArrayList<Serie> ()

        for (item in newList)
        {
            var txt = item.name
            if(txt.contains(query,true))
            {
                filteredList += item
            }
        }

        return filteredList
    }



    /* using the API */
    val clientSerie by lazy {
        SerieAPIClient.create()
    }
    var disposableSerie: Disposable? = null
    private fun showSeries() {

        disposableSerie = clientSerie.getToutesLesSerie(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecyclerSerie(result.results);DataService.seriesAprendreDetails=result.results;},
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    fun setupRecyclerSerie(serieList: List<Serie>) {

        var recyclerView=view?.findViewById<RecyclerView>(R.id.serieGridView) as RecyclerView
        adapter= SerieAdapter(this.context,serieList){serie ->

            val serieIntent=Intent(this.context,detailsSerie::class.java)
            serieIntent.putExtra(EXTRA_SERIE,serie.id)
            startActivity(serieIntent)
        }
        var spanCount=2 //Pour changer le nombre de colonnes selon l'orientation
        val orientation=resources.configuration.orientation //1 for portrait and 2 for landscape
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            spanCount=4
        }
        val screenSize=resources.configuration.screenWidthDp//Pour changer le nombre de colonnes selon la taille du device
        if(screenSize>720)
        {
            spanCount=3
        }
        var mLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this.context,spanCount)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter

    }



}