package app.youcef.com.stock2.Model

/**
 * Created by hp on 18/06/2018.
 */
class FilmesResponse(val page:Int,val total_results:Int, val total_pages:Int,val results:List<Filme>) {
    override fun toString(): String {
        return page.toString()
    }
}