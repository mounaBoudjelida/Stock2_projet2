package app.youcef.com.stock2.Model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import app.youcef.com.stock2.Constants.ApiParam.baseImageURL

/**
 * Created by hp on 19/04/2018.
 */
@Entity
class Filme(@PrimaryKey val id:Int,
            val vote_count:Int?,
            val video:Boolean?,
            val vote_average:Double?,
            val title:String,
            val popularity:Double?,
            val poster_path:String?,
            val original_language:String?,
            val original_title:String?,
            val backdrop_path:String?,
            val adult:Boolean?,
            val overview:String?) {
    override fun toString(): String {
        return title
    }
   fun getImage():String{
       return baseImageURL+poster_path
   }
}