package app.youcef.com.stock2.APIs

import app.youcef.com.stock2.Model.DetailsSerie
import app.youcef.com.stock2.Model.Rating
import app.youcef.com.stock2.Model.ResponseCommentaire
import app.youcef.com.stock2.Model.SeriesResponse
import app.youcef.com.stock2.Constants.ApiParam
import app.youcef.com.stock2.Constants.ApiParam.urlCommentaireSerie
import app.youcef.com.stock2.Constants.ApiParam.urlSerie
import app.youcef.com.stock2.Constants.ApiParam.urlSerieAiringToday
import app.youcef.com.stock2.Constants.ApiParam.urlSimilarSerie
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by hp on 19/06/2018.
 */


interface SerieAPIClient {

    /* Get list of TV show */
    @GET(urlSerieAiringToday)
    fun getSeriesAiringToday(@Query("api_key") api_key: String): Observable<SeriesResponse>

    /* Get one TV show by it's id */
    @GET(urlSimilarSerie)
    fun getSerieLiees(@Path("tv_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<SeriesResponse>
    /* Get details of serie in order to get number of seasons and episodes */
    @GET("tv/{tv_id}")
    fun getDetails(@Path("tv_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<DetailsSerie>
    @POST("tv/{tv_id}/rating")
    fun postRating(@Path("tv_id") tv_id:Int, @Body rating: Rating, @Query("api_key") api_key: String): Observable<DetailsSerie>
    /* Get les series */
    @GET(urlSerie)
    fun getToutesLesSerie(@Query("api_key") api_key: String): Observable<SeriesResponse>
    /* Get reviews about a TV */
    @GET(urlCommentaireSerie)
    fun getCommentairesSerie(@Path("tv_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<ResponseCommentaire>

    companion object {

        fun create(): SerieAPIClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ApiParam.baseURL)
                    .build()

            return retrofit.create(SerieAPIClient::class.java)

        }
    }

}