package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  app.youcef.com.stock2.Adapters.FilmeAdapter
import app.youcef.com.stock2.Controller.DetailsFilme
import  app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_FILME


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_mesFilmes:Fragment(){
    lateinit var adapter:FilmeAdapter
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_mesfilmes, container, false)
         var recyclerView=view.findViewById<RecyclerView>(R.id.mesfilmesGridView) as RecyclerView
         adapter= FilmeAdapter(this.context,DataService.mesFilmes){filme ->
             println(filme.title)
             val filmeIntent= Intent(this.context, DetailsFilme::class.java)
             filmeIntent.putExtra(EXTRA_FILME,filme.id)
             startActivity(filmeIntent)
         }
         var mLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this.context,2)
         recyclerView.layoutManager=mLayoutManager
         recyclerView.adapter=adapter

         return view
    }
}