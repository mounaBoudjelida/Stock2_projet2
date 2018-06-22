package app.youcef.com.stock2.Controller

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Button
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import kotlinx.android.synthetic.main.activity_details_serie.*
import android.widget.LinearLayout
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.widget.TextView
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Model.DetailsSerie
import app.youcef.com.stock2.Model.Rating
import app.youcef.com.stock2.Model.Serie
import app.youcef.com.stock2.Utilities.EXTRA_SAISON
import app.youcef.com.stock2.Constants.ApiParam
import app.youcef.com.stock2.Constants.ApiParam.baseImageURL
import app.youcef.com.stock2.APIs.SerieAPIClient
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers



class detailsSerie : AppCompatActivity() {
    lateinit var adapter: SerieAdapter
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_serie)

        showDetailsSerie(intent.getIntExtra(EXTRA_SERIE,0))
        showSeriesLiees(intent.getIntExtra(EXTRA_SERIE,0))
        showSeasons(intent.getIntExtra(EXTRA_SERIE,0))
        showCommentaires(intent.getIntExtra(EXTRA_SERIE,0))

    }




    /*  Pour recuperer les series liees */
    val clientSerie by lazy {
        SerieAPIClient.create()
    }
    var disposableSerie: Disposable? = null
    private fun showSeriesLiees(id:Int) {

        disposableSerie = clientSerie.getSerieLiees(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->setupRecyclerSerieLiess(result.results)
                            Log.v("rani f serie liees", "" + result.results)
                            DataService.seriesAprendreDetails=result.results},
                        { error -> Log.e("ERROR", error.message) }
                )

    }


    fun setupRecyclerSerieLiess(seriesLieesList: List<Serie>) {

        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewSeriesLiees) as RecyclerView
        adapter= SerieAdapter(this,seriesLieesList){serie ->

            val serieIntent= Intent(this, detailsSerie::class.java)
            serieIntent.putExtra(EXTRA_SERIE,serie.id)
            startActivity(serieIntent)
        }

        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter

    }


    /*  Pour recuperer les details d'une serie */
    val clientDetailsSerie by lazy {
        SerieAPIClient.create()
    }
    var disposableDetailsSerie: Disposable? = null
    private fun showSeasons(id:Int) {

        disposableDetailsSerie=clientDetailsSerie.getDetails(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                       { result ->
                           val ll_main = findViewById<LinearLayout>(R.id.saisonsLayout)
                           val nbSaisons=result.number_of_seasons
                           nbJaimeSerie.text=result.vote_count.toString()
                           /*________Pour ajouter des bouttons dynamiquement selon le nombre de saisons ____*/
                           for (i in 1..nbSaisons){
                               val button_dynamic = Button(this)
                               val params = LinearLayout.LayoutParams(
                                       LinearLayout.LayoutParams.WRAP_CONTENT,
                                       LinearLayout.LayoutParams.WRAP_CONTENT
                               )
                               params.setMargins(10,0,10,0)
                               params.width=80
                               params.height=80
                               button_dynamic.layoutParams = LinearLayout.LayoutParams(params)
                               button_dynamic.text = i.toString()
                               button_dynamic.id=result.id
                               button_dynamic.setBackgroundColor(rgb(54,78,98))
                               button_dynamic.setTextColor(Color.parseColor("#FFEB3B"))
                               val shapedrawable = ShapeDrawable()
                               shapedrawable.shape = RectShape()
                               shapedrawable.paint.color = Color.parseColor("#FFEB3B")
                               shapedrawable.paint.strokeWidth = 3f
                               shapedrawable.getPaint().setStyle(Paint.Style.STROKE);
                               button_dynamic.setBackground(shapedrawable)

                               button_dynamic.setOnClickListener {
                                   val saisonIntent= Intent(this,detailsSaison::class.java)
                                   saisonIntent.putExtra(EXTRA_SAISON,i-1)
                                   startActivity(saisonIntent)
                               }

                               ll_main.addView(button_dynamic)
                           }
                       },
                       { error -> Log.e("ERROR", error.message) }
               )



    }

    /* Pour noter une serie */
    private fun postRating(id:Int) :Observable<DetailsSerie>{

        return clientDetailsSerie.postRating(id, Rating(1.0),ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    }


    val client by lazy {
        SerieAPIClient.create()
    }
    var disposable: Disposable? = null
    private fun showDetailsSerie(id:Int) {

        disposable = client.getDetails(id, ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            Log.v("dans details filme", "" + result)

                            Glide.with(this).load(baseImageURL+result.poster_path).into(imageDetailSerie)
                            detailSerieTitle?.text=result.name
                            detailSerieDescription?.text=result.overview
                            //date?.text=result.release_date
                            Log.v("yyyyyy", ""+result.production_companies)

                        },
                        { error -> Log.e("ERROR", error.message) }
                )

    }


    val clientCommentaire by lazy {
        SerieAPIClient.create()
    }
    var disposableCommentaire: Disposable? = null
    private fun showCommentaires(id:Int) {

        disposableCommentaire = clientCommentaire.getCommentairesSerie(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->val ll_commentaire = findViewById<LinearLayout>(R.id.commentaireLayoutSerie)
                            Log.v("commentaire size serie",""+result.results.size)
                            if(result.results.size==0){

                                val Uncommentaire=TextView(this)
                                val params = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                )
                                params.setMargins(20,0,0,0)
                                Uncommentaire.layoutParams=LinearLayout.LayoutParams(params)
                                Uncommentaire.text="Aucun commentaire pour cette série."
                                Uncommentaire.textSize=16f
                                Uncommentaire.setTextColor(Color.parseColor("#FAFAFA"))
                                ll_commentaire.addView(Uncommentaire)

                            }
                            for(i in 0..result.results.count()-1)
                            {
                                val theAuthor= TextView(this)
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
