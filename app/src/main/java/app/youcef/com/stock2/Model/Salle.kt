package app.youcef.com.stock2.Model

/**
 * Created by hp on 19/04/2018.
 */
class Salle(val nom:String, val photo:String, val adr:String, val long:Double, val lat:Double) {
    override fun toString(): String {
        return nom
    }
}