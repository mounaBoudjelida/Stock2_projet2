package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.youcef.com.stock2.Adapters.FilmeAdapter
import  app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.DetailsFilme
import app.youcef.com.stock2.Controller.detailsSerie
import  app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_SERIE


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_accueil:Fragment(){
    lateinit var adapterFilme:FilmeAdapter
    lateinit var adapterSerie:SerieAdapter
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_accueil,container, false)
         var recyclerView=view.findViewById<RecyclerView>(R.id.recyclerViewFilme) as RecyclerView
         adapterFilme= FilmeAdapter(this.context,DataService.filmesProject){filme ->
             println(filme.title)
             val filmeIntent= Intent(this.context, DetailsFilme::class.java)
             filmeIntent.putExtra(EXTRA_FILME,filme.id)
             startActivity(filmeIntent)
         }
         var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context,OrientationHelper.HORIZONTAL,false)
         recyclerView.layoutManager=mLayoutManager
         recyclerView.adapter=adapterFilme





         var recyclerViewSerie=view.findViewById<RecyclerView>(R.id.recyclerViewSerie) as RecyclerView
         adapterSerie= SerieAdapter(this.context,DataService.series){serie ->
             println(serie.title)
             val serieIntent= Intent(this.context, detailsSerie::class.java)
             serieIntent.putExtra(EXTRA_SERIE,serie.id)
             startActivity(serieIntent)
         }
         var sLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context,OrientationHelper.HORIZONTAL,false)
         recyclerViewSerie.layoutManager=sLayoutManager
         recyclerViewSerie.adapter=adapterSerie

         return view
    }
}