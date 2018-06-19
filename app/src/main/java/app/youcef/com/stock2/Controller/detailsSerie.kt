package app.youcef.com.stock2.Controller

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.Button
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import kotlinx.android.synthetic.main.activity_details_serie.*
import android.widget.LinearLayout
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.provider.ContactsContract
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import android.widget.TextView
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Model.Commentaire
import app.youcef.com.stock2.Model.DetailsSerie
import app.youcef.com.stock2.Model.Serie
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import app.youcef.com.stock2.Utilities.EXTRA_SAISON
import app.youcef.com.stock2.constants.ApiParam
import app.youcef.com.stock2.remote.SerieAPIClient
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details_filme.*
import java.util.*


class detailsSerie : AppCompatActivity() {
    lateinit var adapter: SerieAdapter
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var nombreJaime=0
        var nombreJaimePas=0
        setContentView(R.layout.activity_details_serie)
        val index=findSerie(intent.getIntExtra(EXTRA_SERIE,0))
        Log.v("index check", "" +DataService.seriesEnCoursDeProjection[index].getImage())
        Glide.with(this).load(DataService.seriesEnCoursDeProjection[index].getImage()).into(imageDetailSerie)

        detailSerieTitle?.text=DataService.seriesEnCoursDeProjection[index].name
        detailSerieDescription?.text=DataService.seriesEnCoursDeProjection[index].overview
        showSeriesLiees(intent.getIntExtra(EXTRA_SERIE,0))


        val ll_main = findViewById<LinearLayout>(R.id.saisonsLayout)
        val ll_commentaire = findViewById<LinearLayout>(R.id.commentaireLayout)
        //var lesSaisons=resources.getIntArray(R.array.saisons)
        var nbSaisons=0
        showSeasons(DataService.seriesEnCoursDeProjection[index].id).subscribe(
                { result ->nbSaisons=result.number_of_seasons
                    nombreJaime=result.vote_count
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
                        button_dynamic.id=index+i
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


        /*________Pour ajouter des commentaires dynamiquement a paratir de la liste des commentaires ____*/
        var lesCommentairesDeLaSerie:ArrayList<Commentaire>
        lesCommentairesDeLaSerie=DataService.getListeCommentaireSerie(DataService.seriesEnCoursDeProjection[index].name)
        for(i in 0..lesCommentairesDeLaSerie.count()-1)
        {
            val commentaire=TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams=LinearLayout.LayoutParams(params)
            commentaire.text="- "+lesCommentairesDeLaSerie[i].toString()
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)

        }
        btnAjouterSerie.setOnClickListener {
            DataService.addCommentaireSerie(Commentaire(insererCommentaireSerie.text.toString()),DataService.seriesEnCoursDeProjection[index].name)
            val commentaire=TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams=LinearLayout.LayoutParams(params)
            commentaire.text="- "+Commentaire(insererCommentaireSerie.text.toString())
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)
            insererCommentaireSerie.text.clear()
        }


        nbJaimePasSerie.text=nombreJaimePas.toString()
        iconJaimeSerie.setOnClickListener {
            iconJaimeSerie.setColor(Color.parseColor("#FFEB3B"))

            nbJaimeSerie.text=(nombreJaime+1).toString()

        }
        iconJaimePasSerie.setOnClickListener {
            iconJaimePasSerie.setColor(Color.parseColor("#FFEB3B"))

            nbJaimePasSerie.text=(nombreJaimePas+1).toString()

        }



    }

    fun findSerie(id:Int):Int{
        var bool=true
        var i=0
        while(bool==true && i<DataService.seriesEnCoursDeProjection.size){
            if(DataService.seriesEnCoursDeProjection[i].id==id){ bool=false ;}
            i++
        }
        return i-1

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
                            DataService.seriesEnCoursDeProjection=result.results;},
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
    private fun showSeasons(id:Int) :Observable<DetailsSerie>{

       return clientDetailsSerie.getDetails(id,ApiParam.apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    }




}
