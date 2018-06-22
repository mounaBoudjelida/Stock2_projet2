package app.youcef.com.stock2.Model

import app.youcef.com.stock2.Constants.ApiParam.baseImageURL

/**
 * Created by hp on 21/06/2018.
 */
class ProductionCompany(val id:Int,
                        val logo_path:String?,
                        val name:String,
                        val origin_country:String?
                        ){
    fun getlogo():String{
        return baseImageURL+logo_path
    }
}