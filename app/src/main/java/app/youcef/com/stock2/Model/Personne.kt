package app.youcef.com.stock2.Model

/**
 * Created by hp on 17/04/2018.
 */
class Personne(val nomPrenom:String,val dateNaissance:String,val photo:String){
     override fun toString(): String {
        return nomPrenom
    }
}