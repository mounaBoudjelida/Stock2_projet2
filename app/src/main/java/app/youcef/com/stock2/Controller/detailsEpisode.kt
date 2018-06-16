package app.youcef.com.stock2.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import app.youcef.com.stock2.Model.Commentaire
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_EPISODE
import app.youcef.com.stock2.Utilities.EXTRA_SAISON
import kotlinx.android.synthetic.main.activity_details_episode.*



class detailsEpisode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_episode)
        val index=intent.getIntExtra(EXTRA_EPISODE,0)
        detailEpisodeTitle?.text=DataService.episodes[index].title+"-"+DataService.episodes[index].saison+"-"+DataService.episodes[index].numero
        detailEpisodeDescription?.text="Les chaînes : Cinéma - Séries TV. Toutes les chaînes Cinéma - Séries TV. Le cinéma et les séries TV sont à l'honneur sur les chaines cinéma. Que vous aimiez les films classiques ou les films récents, il y a forcément"
        nbJaimeEpisode.text=DataService.nbJaimeActeur1.toString()
        nbJaimePasEpisode.text=DataService.nbJaimePasActeur1.toString()
        iconJaime.setOnClickListener {
            iconJaime.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimeActeur1=DataService.nbJaimeActeur1+1
            nbJaimeEpisode.text=DataService.nbJaimeActeur1.toString()

        }
        iconJaimePas.setOnClickListener {
            iconJaimePas.setColor(Color.parseColor("#FFEB3B"))
            DataService.nbJaimePasActeur1=DataService.nbJaimePasActeur1+1
            nbJaimePasEpisode.text=DataService.nbJaimePasActeur1.toString()

        }
        btnAjouter.setOnClickListener {
            //DataService.addCommentairePersonne(Commentaire(insererCommentairePersonne.text.toString()),DataService.personnes[personneIndex].nomPrenom)
            commentaire1?.text=insererCommentaire.text.toString()
            insererCommentaire.text.clear()

        }



    }
}
