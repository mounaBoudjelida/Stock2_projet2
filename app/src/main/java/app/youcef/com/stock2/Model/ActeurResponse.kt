package app.youcef.com.stock2.Model

/**
 * Created by hp on 19/06/2018.
 */
class ActeurResponse(val page:Int, val total_results:Int, val total_pages:Int, val results:List<Personne>){
    override fun toString(): String {
        return page.toString()
    }
}