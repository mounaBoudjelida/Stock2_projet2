package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  app.youcef.com.stock2.Adapters.FilmeAdapter
import  app.youcef.com.stock2.Services.DataService
import kotlinx.android.synthetic.main.fragment_filme.*

import android.widget.*

import android.support.v7.widget.SearchView.*

import android.util.Log
import android.support.v4.widget.SearchViewCompat.getQuery
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Controller.DetailsFilme
import app.youcef.com.stock2.Controller.detailsSerie
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_SERIE


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_filme:Fragment(){
    lateinit var adapter:FilmeAdapter
    lateinit var recyclerView : RecyclerView
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_filme, container, false)
         recyclerView=view.findViewById<RecyclerView>(R.id.filmeGridView) as RecyclerView
         adapter= FilmeAdapter(this.context,DataService.filmes){filme ->
             println(filme.title)
             val filmeIntent= Intent(this.context, DetailsFilme::class.java)
             filmeIntent.putExtra(EXTRA_FILME,filme.id)
             startActivity(filmeIntent)
         }

         var mLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this.context,2) as RecyclerView.LayoutManager
         recyclerView.layoutManager=mLayoutManager
         recyclerView.adapter=adapter

         return view
    }




    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchFilme.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {

                var recyclerView=view!!.findViewById<RecyclerView>(R.id.filmeGridView) as RecyclerView
                //adapter= FilmeAdapter(context,DataService.mesFilmes)


                if(newText.isNullOrBlank() == true  ){
                    adapter = FilmeAdapter(context,DataService.filmes){filme ->
                        println(filme.title)
                        val filmeIntent= Intent(context, DetailsFilme::class.java)
                        filmeIntent.putExtra(EXTRA_FILME,filme.id)
                        startActivity(filmeIntent)
                    }
                }else {
                    if(newText != null){
                        val modelfiltre  = filter(newText,DataService.filmes)
                        adapter= FilmeAdapter(context,modelfiltre){filme ->
                            println(filme.title)
                            val filmeIntent= Intent(context, DetailsFilme::class.java)
                            filmeIntent.putExtra(EXTRA_FILME,filme.id)
                            startActivity(filmeIntent)
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

    private fun filter(query:String,newList:List<Filme>):List<Filme>{
        val filteredList = ArrayList<Filme> ()

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