package app.youcef.com.stock2.Model

/**
 * Created by hp on 19/06/2018.
 */
class SeriesResponse(val page:Int,val total_results:Int, val total_pages:Int,val results:List<Serie>) {
    override fun toString(): String {
        return page.toString()
    }
}