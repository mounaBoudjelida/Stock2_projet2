package app.youcef.com.stock2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager

        setSupportActionBar(tb)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)


        fm.beginTransaction().replace(R.id.content, Fragment_accueil()).commit()

        navigation.setNavigationItemSelectedListener { item: MenuItem ->
            drawer.closeDrawers()
            item.isChecked = true
            when(item.itemId){
                R.id.accueil -> {
                    fm.beginTransaction().replace(R.id.content, Fragment_accueil()).commit()
                }
                R.id.cinema -> {
                    fm.beginTransaction().replace(R.id.content, Fragment_cinema()).commit()
                }
                R.id.personne -> {
                    fm.beginTransaction().replace(R.id.content, Fragment_personne()).commit()                }
                R.id.serie -> {
                    fm.beginTransaction().replace(R.id.content, Fragment_serie()).commit()
                }
                R.id.fan -> {
                    fm.beginTransaction().replace(R.id.content, Fragment_fan()).commit()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
