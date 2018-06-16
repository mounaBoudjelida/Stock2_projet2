package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.detailsSerie
import app.youcef.com.stock2.R.id.serie
import  app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_SERIE


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_mesSeries:Fragment(){
    lateinit var adapter:SerieAdapter
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_messeries, container, false)
         var recyclerView=view.findViewById<RecyclerView>(R.id.messerieGridView) as RecyclerView
         adapter= SerieAdapter(this.context,DataService.series){serie ->
             println(serie.title)
             val serieIntent= Intent(this.context, detailsSerie::class.java)
             serieIntent.putExtra(EXTRA_SERIE,serie.id)
             startActivity(serieIntent)
         }
         var mLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this.context,2)
         recyclerView.layoutManager=mLayoutManager
         recyclerView.adapter=adapter

         return view
    }
}