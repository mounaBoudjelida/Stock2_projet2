package app.youcef.com.stock2.Controller

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.View
import android.widget.*
import app.youcef.com.stock2.Adapters.FilmeAdapter
import app.youcef.com.stock2.Model.Commentaire
import app.youcef.com.stock2.Utilities.EXTRA_FILME
import kotlinx.android.synthetic.main.activity_details_filme.*


class DetailsFilme : AppCompatActivity() {
    lateinit var adapter:FilmeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_filme)
        val index=intent.getIntExtra(EXTRA_FILME,0)
        val resourceId=this.resources.getIdentifier(DataService.filmes[index].photo,"drawable",this.packageName)
        var lesDesriptions=resources.getStringArray(R.array.Desriptionfilme)
        imageDetailFilme?.setImageResource(resourceId)
        detailFilmeTitle?.text=DataService.filmes[index].title
        detailFilmeDescription?.text=lesDesriptions[index]
        acteursLies?.text = resources.getStringArray(R.array.acteurs)[index]
        salleProject?.text = DataService.filmes[index].salle



        //val emplacement = "android.ressource//"+ packageName+"/raw/"+R.raw.video4
        var emplacement ="android.resource://"+packageName+"/"
        if(detailFilmeTitle.text == "Pirates des caraïbes")
        {
            emplacement = emplacement+""+R.raw.video4
        }else if(detailFilmeTitle.text == "Avatar 2"){
            emplacement =emplacement +R.raw.video1
        }else{
            videoViewFilme.visibility = View.INVISIBLE
        }




        val videoViewf = findViewById<View>(R.id.videoViewFilme) as VideoView
        videoViewf.setVideoURI(Uri.parse(emplacement))

        videoViewf.setMediaController(MediaController(this))





        var recyclerView= findViewById<RecyclerView>(R.id.recyclerViewFilmeLies) as RecyclerView
        adapter= FilmeAdapter(this,DataService.filmesLies[index]){filme ->
            println(filme.title)
            val filmeIntent= Intent(this, DetailsFilme::class.java)
            filmeIntent.putExtra(EXTRA_FILME,filme.id)
            startActivity(filmeIntent)
        }

        var mLayoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=adapter


        val ll_commentaire = findViewById<LinearLayout>(R.id.commentaireLayout)

        /*________Pour ajouter des commentaires dynamiquement a paratir de la liste des commentaires ____*/
        var lesCommentairesFilme:ArrayList<Commentaire>
        lesCommentairesFilme=DataService.getListeCommentaireFilme(DataService.filmes[index].title)
        for(i in 0..lesCommentairesFilme.count()-1)
        {
            val commentaire=TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams=LinearLayout.LayoutParams(params)
            commentaire.text="- "+lesCommentairesFilme[i].toString()
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)

        }
        btnAjouter.setOnClickListener {
            DataService.addCommentaireFilme(Commentaire(insererCommentaire.text.toString()),DataService.filmes[index].title)
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

        nbJaime.text=DataService.nbJaimeFilme1.toString()
        nbJaimePas.text=DataService.nbJaimePasFilme1.toString()
        iconJaime.setOnClickListener {
            iconJaime.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimeFilme1=DataService.nbJaimeFilme1+1
            nbJaime.text=DataService.nbJaimeFilme1.toString()

        }
        iconJaimePas.setOnClickListener {
            iconJaimePas.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimePasFilme1=DataService.nbJaimePasFilme1+1
            nbJaimePas.text=DataService.nbJaimePasFilme1.toString()
        }
    }
}
