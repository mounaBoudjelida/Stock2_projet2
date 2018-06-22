package  app.youcef.com.stock2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  app.youcef.com.stock2.Adapters.FilmeAdapter
import  app.youcef.com.stock2.Services.DataService
import kotlinx.android.synthetic.main.fragment_filme.*

import android.util.Log
import android.support.v7.widget.*
import android.support.v7.widget.SearchView
import app.youcef.com.stock2.Controller.DetailsFilme
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Constants.ApiParam.apiKey
import app.youcef.com.stock2.APIs.FilmeAPIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by hp on 17/04/2018.
 */
class Fragment_filme:Fragment(){
    lateinit var adapter:FilmeAdapter
    lateinit var recyclerView : RecyclerView
     override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var view= inflater!!.inflate(R.layout.fragment_filme, container, false)

         showMovies()




         return view
    }




    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchFilme.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {

                var recyclerView=view!!.findViewById<RecyclerView>(R.id.filmeGridView) as RecyclerView
                //adapter= FilmeAdapter(context,DataService.mesFilmes)


                if(newText.isNullOrBlank() == true  ){
                    adapter = FilmeAdapter(context,DataService.filmesAprendreDetails){filme ->
                        println(filme.title)
                        val filmeIntent= Intent(context, DetailsFilme::class.java)
                        filmeIntent.putExtra(EXTRA_FILME,filme.id)
                        startActivity(filmeIntent)
                    }
                }else {
                    if(newText != null){
                        val modelfiltre  = filter(newText,DataService.filmesAprendreDetails)
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



    /* using the API */
    val clientFilm by lazy {
        FilmeAPIClient.create()
    }
    var disposableFilm: Disposable? = null
    private fun showMovies() {

        disposableFilm = clientFilm.getMoviesPopular(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecyclerMovie(result.results);DataService.filmesAprendreDetails=result.results;},
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    fun setupRecyclerMovie(movieList: List<Filme>) {

        recyclerView=view?.findViewById<RecyclerView>(R.id.filmeGridView) as RecyclerView
        adapter= FilmeAdapter(this.context,movieList){filme ->
            println(filme.title)
            val filmeIntent= Intent(this.context, DetailsFilme::class.java)
            filmeIntent.putExtra(EXTRA_FILME,filme.id)
            startActivity(filmeIntent)
        }

        var mLayoutManager:RecyclerView.LayoutManager= GridLayoutManager(this.context,2) as RecyclerView.LayoutManager
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter
    }
}