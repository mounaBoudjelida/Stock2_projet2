package app.youcef.com.stock2.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.youcef.com.stock2.R
import app.youcef.com.stock2.Services.DataService
import app.youcef.com.stock2.Utilities.EXTRA_EPISODE
import app.youcef.com.stock2.Utilities.EXTRA_SAISON
import app.youcef.com.stock2.Utilities.EXTRA_SERIE
import kotlinx.android.synthetic.main.activity_details_saison.*

class detailsSaison : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_saison)
        val index=intent.getIntExtra(EXTRA_SAISON,0)

        val resourceId=this.resources.getIdentifier(DataService.saison[index].photo,"drawable",packageName)
        imageDetailSaison?.setImageResource(resourceId)
        detailSaisonTitle?.text=DataService.saison[index].title+"  "+DataService.saison[index].numero
        episode1.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,1)
            startActivity(episodeIntent)
        }
        episode1.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,2)
            startActivity(episodeIntent)
        }
        episode2.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,1)
            startActivity(episodeIntent)
        }
        episode3.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,3)
            startActivity(episodeIntent)
        }
        episode4.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,4)
            startActivity(episodeIntent)
        }
        episode5.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,5)
            startActivity(episodeIntent)
        }
        episode6.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,6)
            startActivity(episodeIntent)
        }
        episode7.setOnClickListener {

            val episodeIntent= Intent(this,detailsEpisode::class.java)
            episodeIntent.putExtra(EXTRA_EPISODE,7)
            startActivity(episodeIntent)
        }

    }
}
