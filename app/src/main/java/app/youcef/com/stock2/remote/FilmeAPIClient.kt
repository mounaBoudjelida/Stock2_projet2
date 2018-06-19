package app.youcef.com.stock2.remote

/**
 * Created by hp on 18/06/2018.
 */
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.Model.FilmesResponse
import app.youcef.com.stock2.constants.ApiParam.baseURL
import app.youcef.com.stock2.constants.ApiParam.urlMovieTopRated
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface FilmeAPIClient {

    /* Get list of articles */
    @GET("movie/top_rated")
    fun getArticles(@Query("api_key") api_key: String): Observable<FilmesResponse>

    /* Get one article by it's id */
    @GET(urlMovieTopRated)
    fun getArticle(@Query("api_key") api_key: String): Observable<FilmesResponse>


    companion object {

        fun create(): FilmeAPIClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseURL)
                    .build()

            return retrofit.create(FilmeAPIClient::class.java)

        }
    }

}