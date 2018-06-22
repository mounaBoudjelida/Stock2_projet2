package app.youcef.com.stock2.Model

import app.youcef.com.stock2.Constants.ApiParam.baseImageURL

/**
 * Created by hp on 19/04/2018.
 */

class Filme(val id:Int,
            val vote_count:Int?,
            val video:Boolean?,
            val vote_average:Double?,
            val title:String,
            val popularity:Double?,
            val poster_path:String?,
            val original_language:String?,
            val original_title:String?,
            val genre_ids:List<Int>?,
            val backdrop_path:String?,
            val adult:Boolean?,
            val overview:String?,
            val listActeur: List<Personne>?, val listFilm : List<Filme>?, val salle : String?) {
    override fun toString(): String {
        return title
    }
   fun getImage():String{
       return baseImageURL+poster_path
   }
}