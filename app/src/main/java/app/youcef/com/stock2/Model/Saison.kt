package app.youcef.com.stock2.Model

/**
 * Created by hp on 21/04/2018.
 */
class Saison(val title:String,val numero:Int, val photo:String) {
    override fun toString(): String {
        return title+" "+numero.toString()
    }
}