package app.youcef.com.stock2.Model

import app.youcef.com.stock2.Constants.ApiParam.baseImageURL

/**
 * Created by hp on 17/04/2018.
 */
class Personne(val popularity:String?,val id:Int,val profile_path:String?, val name :String,
               val known_for:List<Filme>?, val adult:Boolean?  ){
     override fun toString(): String {
        return name
    }
    fun getImage():String{
        return baseImageURL+profile_path
    }
}