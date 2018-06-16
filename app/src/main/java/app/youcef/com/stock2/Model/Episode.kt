package app.youcef.com.stock2.Model

import android.provider.ContactsContract

/**
 * Created by hp on 22/04/2018.
 */
class Episode(val title:String,val saison:Int,val numero:Int, val photo: String) {
     override fun toString(): String {
        return title
    }
}