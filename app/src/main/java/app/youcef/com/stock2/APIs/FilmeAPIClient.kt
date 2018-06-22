package app.youcef.com.stock2.APIs

/**
 * Created by hp on 18/06/2018.
 */

import app.youcef.com.stock2.Model.DetailsFilme
import app.youcef.com.stock2.Model.FilmesResponse
import app.youcef.com.stock2.Model.ResponseCommentaire
import app.youcef.com.stock2.Constants.ApiParam.baseURL
import app.youcef.com.stock2.Constants.ApiParam.urlCommentaireMovie
import app.youcef.com.stock2.Constants.ApiParam.urlDetailsFilm
import app.youcef.com.stock2.Constants.ApiParam.urlMovieNowPlaying
import app.youcef.com.stock2.Constants.ApiParam.urlMoviePopular
import app.youcef.com.stock2.Constants.ApiParam.urlSimilarMovies
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface FilmeAPIClient {

    /* Get list of movies for accueil page  */
    @GET(urlMovieNowPlaying)
    fun getMoviesNowPlaying(@Query("api_key") api_key: String): Observable<FilmesResponse>
    /* Get list of movies for Movies page  */
    @GET(urlMoviePopular)
    fun getMoviesPopular(@Query("api_key") api_key: String): Observable<FilmesResponse>

    /* Get one movie by it's id */

    /* Get details of a movie */
    @GET(urlDetailsFilm)
    fun getDetails(@Path("movie_id") movie_id:Int ,@Query("api_key") api_key: String): Observable<DetailsFilme>
    /* Get related movies */
    @GET(urlSimilarMovies)
    fun getMoviesLiees(@Path("movie_id") movie_id:Int ,@Query("api_key") api_key: String): Observable<FilmesResponse>
    /* Get reviews about a movie */
    @GET(urlCommentaireMovie)
    fun getCommentairesMovie(@Path("movie_id") movie_id:Int ,@Query("api_key") api_key: String): Observable<ResponseCommentaire>


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