package app.youcef.com.stock2


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_cinema.*
import kotlinx.android.synthetic.main.fragment_cinema.view.*


class Fragment_fan: Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_fan, container, false)


        var fm = fragmentManager
        fm.beginTransaction().replace(R.id.pagerFan,Fragment_mesFilmes()).commit()
        rootView.tab_layout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.text){
                    getString(R.string.mesFilmes) ->{
                        var fm = fragmentManager
                        fm.beginTransaction().replace(R.id.pagerFan,Fragment_mesFilmes()).commit()
                    }
                    getString(R.string.mesFeuilltons) ->{
                        var fm = fragmentManager
                        fm.beginTransaction().replace(R.id.pagerFan,Fragment_mesSeries()).commit()
                    }
                    getString(R.string.mesSalles) ->{
                        var fm = fragmentManager
                        fm.beginTransaction().replace(R.id.pagerFan,Fragment_mesSalles()).commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
        return rootView
    }

}