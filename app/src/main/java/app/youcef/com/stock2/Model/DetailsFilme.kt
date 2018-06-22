package app.youcef.com.stock2.Model

/**
 * Created by hp on 21/06/2018.
 */
class DetailsFilme(val id:Int,
                   val original_title:String,
                   val overview:String,
                   val poster_path:String,
                   val production_companies:List<ProductionCompany>,
                   val release_date:String?
                   )