package app.youcef.com.stock2.Model


class Commentaire(val author:String?,
                  val content:String,
                  val id:String,
                  val url:String?) {
    override fun toString(): String {
        return content
    }

}