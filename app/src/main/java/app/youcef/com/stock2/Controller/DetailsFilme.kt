package app.youcef.com.stock2.Controller

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.widget.*
import app.youcef.com.stock2.Adapters.FilmeAdapter
import app.youcef.com.stock2.Adapters.ProductionCompanyAdapter
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Model.ProductionCompany
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Constants.ApiParam
import app.youcef.com.stock2.Constants.ApiParam.baseImageURL
import app.youcef.com.stock2.APIs.FilmeAPIClient
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details_filme.*


class DetailsFilme : AppCompatActivity() {
    lateinit var adapter:FilmeAdapter
    lateinit var adapterProdCompany:ProductionCompanyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_filme)
        showDetailsFilm(intent.getIntExtra(EXTRA_FILME,0))
        showFilmesLiees(intent.getIntExtra(EXTRA_FILME,0))
        showProductionCompany(intent.getIntExtra(EXTRA_FILME,0))
        showCommentaires(intent.getIntExtra(EXTRA_FILME,0))

    }


    val clientFilme by lazy {
        FilmeAPIClient.create()
    }
    var disposableFilme: Disposable? = null
    private fun showDetailsFilm(id:Int) {

        disposableFilme = clientFilme.getDetails(id, ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            Log.v("dans details filme", "" + result)
                            Glide.with(this).load(baseImageURL+result.poster_path).into(imageDetailFilme)
                            detailFilmeTitle?.text=result.original_title
                            detailFilmeDescription?.text=result.overview
                            dateRealisationFilmeContent?.text=result.release_date


                        },
                        { error -> Log.e("ERROR", error.message) }
                )

    }


    /*  Pour recuperer les filmes liees */
    val clientFilmeLies by lazy {
        FilmeAPIClient.create()
    }
    var disposableFilmeLies: Disposable? = null
    private fun showFilmesLiees(id:Int) {

        disposableFilmeLies = clientFilmeLies.getMoviesLiees(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->setupRecyclerFilmesLies(result.results)
                            DataService.filmesAprendreDetails=result.results;},
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    fun setupRecyclerFilmesLies(filmesLiesList: List<Filme>) {

        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewFilmeLies) as RecyclerView
        adapter= FilmeAdapter(this,filmesLiesList){filme ->

            val filmeIntent= Intent(this, DetailsFilme::class.java)
            filmeIntent.putExtra(EXTRA_FILME,filme.id)
            startActivity(filmeIntent)
        }

        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter

    }

    fun setupRecyclerProductionCompany(productionCompanyList: List<ProductionCompany>) {

        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewProductionCompany) as RecyclerView
        adapterProdCompany= ProductionCompanyAdapter(this,productionCompanyList){ productionCompany ->

            /*val prodCompanyIntent= Intent(this, DetailsFilme::class.java)
            prodCompanyIntent.putExtra(EXTRA_FILME,productionCompany.id)
            startActivity(prodCompanyIntent)*/
            Log.v("setupRecyclerProd", "" )
        }

        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapterProdCompany

    }

    val c by lazy {
        FilmeAPIClient.create()
    }
    var d: Disposable? = null
    private fun showProductionCompany(id:Int) {

        d = c.getDetails(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->setupRecyclerProductionCompany(result.production_companies)
                            Log.v("rani f film liees", "" + result.production_companies)
                            },
                        { error -> Log.e("ERROR", error.message) }
                )

    }

    val clientCommentaire by lazy {
        FilmeAPIClient.create()
    }
    var disposableCommentaire: Disposable? = null
    private fun showCommentaires(id:Int) {

        disposableCommentaire = clientCommentaire.getCommentairesMovie(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->val ll_commentaire = findViewById<LinearLayout>(R.id.commentaireLayoutFilm)
                            Log.v("commentaire size",""+result.results.size)
                            for(i in 0..result.results.count()-1)
                            {
                                val theAuthor=TextView(this)
                                val p= LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                                p.setMargins(20,10,0,0)
                                theAuthor.layoutParams=LinearLayout.LayoutParams(p)
                                theAuthor.text=result.results[i].author
                                theAuthor.setTextColor(Color.parseColor("#FFEB3B"))
                                ll_commentaire.addView(theAuthor)


                                val Uncommentaire=TextView(this)
                                val params = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                                params.setMargins(20,10,0,0)
                                Uncommentaire.layoutParams=LinearLayout.LayoutParams(params)
                                Uncommentaire.text="    "+result.results[i].content
                                Uncommentaire.textSize=16f
                                Uncommentaire.setTextColor(Color.parseColor("#FAFAFA"))
                                ll_commentaire.addView(Uncommentaire)

                                val uneLigne=TextView(this)
                                val param=LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                                param.setMargins(50,10,50,10)
                                uneLigne.layoutParams=LinearLayout.LayoutParams(param)
                                uneLigne.text="______________________________________________"
                                uneLigne.setTextColor(Color.parseColor("#FAFAFA"))
                                ll_commentaire.addView(uneLigne)



                            }



                        },
                        { error -> Log.e("ERROR here", error.message) }
                )

    }


}
