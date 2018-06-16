package app.youcef.com.stock2

import android.content.Intent
import android.content.res.Configuration
import android.media.VolumeShaper
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.youcef.com.stock2.Adapters.FilmeAdapter
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.DetailsFilme
import app.youcef.com.stock2.Controller.detailsSerie
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Model.Serie
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import kotlinx.android.synthetic.main.fragment_filme.*
import kotlinx.android.synthetic.main.fragment_serie.*


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_serie:Fragment(){
    lateinit var adapter:SerieAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view= inflater!!.inflate(R.layout.fragment_serie, container, false)
        var recyclerView=view.findViewById<RecyclerView>(R.id.serieGridView) as RecyclerView
        adapter= SerieAdapter(this.context,DataService.series){serie ->
            println(serie.title)
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
                    adapter = SerieAdapter(context,DataService.series){serie ->
                        println(serie.title)
                        val serieIntent= Intent(context, detailsSerie::class.java)
                        serieIntent.putExtra(EXTRA_SERIE,serie.id)
                        startActivity(serieIntent)
                    }
                }else {
                    if(newText != null){
                        val modelfiltre  = filter(newText,DataService.series)
                        adapter= SerieAdapter(context,modelfiltre){serie ->
                            println(serie.title)
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
            var txt = item.title
            if(txt.contains(query,true))
            {
                filteredList += item
            }
        }

        return filteredList
    }
}