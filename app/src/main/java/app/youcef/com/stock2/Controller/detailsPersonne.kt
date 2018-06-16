package app.youcef.com.stock2.Controller

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.LinearLayout
import android.widget.TextView
import app.youcef.com.stock2.Model.Commentaire
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_PERSONNE
import kotlinx.android.synthetic.main.activity_details_personne.*

class detailsPersonne : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_personne)
        val personneIndex= intent.getIntExtra(EXTRA_PERSONNE,-1)
        val resourceId=this.resources.getIdentifier(DataService.personnes[personneIndex].photo,"drawable",this.packageName)
        var lesBiographies=resources.getStringArray(R.array.Biographie)
        var lesFilmographie=resources.getStringArray(R.array.Filmographie)
        imageDetails?.setImageResource(resourceId)
        textViewDetails?.text=DataService.personnes[personneIndex].nomPrenom
        dateNaissance?.text=DataService.personnes[personneIndex].dateNaissance
        biographieContent?.text=lesBiographies[personneIndex]
        filmographieContent?.text=lesFilmographie[personneIndex]
        val ll_commentaire = findViewById<LinearLayout>(R.id.commentairePersonneLayout)
        var lesCommentairesDeLaPersonne:ArrayList<Commentaire>
        lesCommentairesDeLaPersonne=DataService.getListeCommentairePersonne(DataService.personnes[personneIndex].nomPrenom)
        for(i in 0..lesCommentairesDeLaPersonne.count()-1)
        {
            val commentaire= TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams= LinearLayout.LayoutParams(params)
            commentaire.text="- "+lesCommentairesDeLaPersonne[i].toString()
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)
        }



        btnAjouterPersonne.setOnClickListener {
            DataService.addCommentairePersonne(Commentaire(insererCommentairePersonne.text.toString()),DataService.personnes[personneIndex].nomPrenom)
            val commentaire= TextView(this)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(20,10,0,0)
            commentaire.layoutParams=LinearLayout.LayoutParams(params)
            commentaire.text="- "+Commentaire(insererCommentairePersonne.text.toString())
            commentaire.textSize=16f
            commentaire.setTextColor(Color.parseColor("#FAFAFA"))
            ll_commentaire.addView(commentaire)
            insererCommentairePersonne.text.clear()
        }


        nbJaime.text=DataService.nbJaimeActeur1.toString()
        nbJaimePas.text=DataService.nbJaimePasActeur1.toString()
        iconJaimePersonne.setOnClickListener {
            iconJaimePersonne.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimeActeur1=DataService.nbJaimeActeur1+1
            nbJaime.text=DataService.nbJaimeActeur1.toString()

        }
       iconJaimePasPersonne.setOnClickListener {
           iconJaimePasPersonne.setColor(Color.parseColor("#FFEB3B"))
           DataService.nbJaimePasActeur1=DataService.nbJaimePasActeur1+1
           nbJaimePas.text=DataService.nbJaimePasActeur1.toString()

       }



    }
}
