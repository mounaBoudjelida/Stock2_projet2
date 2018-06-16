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
import android.widget.TextView
import app.youcef.com.stock2.Adapters.SerieAdapter
import app.youcef.com.stock2.Model.Commentaire
import app.youcef.com.stock2.Utilities.EXTRA_SAISON


class detailsSerie : AppCompatActivity() {
    lateinit var adapter: SerieAdapter
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("llllllllllllllllllllllllllllllllllllllllllllll")

        setContentView(R.layout.activity_details_serie)
        val index=intent.getIntExtra(EXTRA_SERIE,0)
        val resourceId=this.resources.getIdentifier(DataService.series[index].photo,"drawable",this.packageName)
        var lesDesriptions=resources.getStringArray(R.array.Desription)
        imageDetailSerie?.setImageResource(resourceId)
        detailSerieTitle?.text=DataService.series[index].title
        detailSerieDescription?.text=lesDesriptions[index]

        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewSeriesLiees) as RecyclerView
        adapter= SerieAdapter(this,DataService.seriesLiees[index]){serie ->
            println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+serie.title)
            val serieIntent= Intent(this, detailsSerie::class.java)
            serieIntent.putExtra(EXTRA_SERIE,serie.id)
            startActivity(serieIntent)
        }

        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter

        val ll_main = findViewById<LinearLayout>(R.id.saisonsLayout)
        val ll_commentaire = findViewById<LinearLayout>(R.id.commentaireLayout)
        var lesSaisons=resources.getIntArray(R.array.saisons)
        var nbSaisons=lesSaisons[index]
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
        /*________Pour ajouter des commentaires dynamiquement a paratir de la liste des commentaires ____*/
        var lesCommentairesDeLaSerie:ArrayList<Commentaire>
        lesCommentairesDeLaSerie=DataService.getListeCommentaireSerie(DataService.series[index].title)
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
        btnAjouter.setOnClickListener {
            DataService.addCommentaireSerie(Commentaire(insererCommentaire.text.toString()),DataService.series[index].title)
            val commentaire=TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams=LinearLayout.LayoutParams(params)
            commentaire.text="- "+Commentaire(insererCommentaire.text.toString())
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)
            insererCommentaire.text.clear()
        }
        nbJaime.text=DataService.nbJaimeSerie1.toString()
        nbJaimePas.text=DataService.nbJaimePasSerie1.toString()
        iconJaime.setOnClickListener {
            iconJaime.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimeSerie1=DataService.nbJaimeSerie1+1
            nbJaime.text=DataService.nbJaimeSerie1.toString()

        }
        iconJaimePas.setOnClickListener {
            iconJaimePas.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimePasSerie1=DataService.nbJaimePasSerie1+1
            nbJaimePas.text=DataService.nbJaimePasSerie1.toString()

        }



    }
}
