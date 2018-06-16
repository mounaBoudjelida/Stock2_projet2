package  app.youcef.com.stock2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.youcef.com.stock2.Adapters.SalleAdapter
import app.youcef.com.stock2.Adapters.SerieAdapter
import  app.youcef.com.stock2.Services.DataService


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_salle:Fragment(){
    lateinit var adapter:SalleAdapter
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_salle, container, false)

         var recyclerViewSerie=view.findViewById<RecyclerView>(R.id.salleGridView) as RecyclerView
         adapter= SalleAdapter(this.context,DataService.salles)
         var sLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this.context, OrientationHelper.VERTICAL,false)
         recyclerViewSerie.layoutManager=sLayoutManager
         recyclerViewSerie.adapter=adapter

         return view
    }
}