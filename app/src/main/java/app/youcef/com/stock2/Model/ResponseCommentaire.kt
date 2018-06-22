package app.youcef.com.stock2.Model

/**
 * Created by hp on 22/06/2018.
 */
class ResponseCommentaire(val id:Int,
                          val page:Int,
                          val results:List<Commentaire>,
                          val total_pages:Int,
                          val total_results:Int

)