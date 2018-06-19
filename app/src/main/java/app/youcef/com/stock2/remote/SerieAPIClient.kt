package app.youcef.com.stock2.remote

import app.youcef.com.stock2.Model.DetailsSerie
import app.youcef.com.stock2.Model.SeriesResponse
import app.youcef.com.stock2.constants.ApiParam
import app.youcef.com.stock2.constants.ApiParam.urlSerieAiringToday
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by hp on 19/06/2018.
 */


interface SerieAPIClient {

    /* Get list of TV show */
    @GET(urlSerieAiringToday)
    fun getSeries(@Query("api_key") api_key: String): Observable<SeriesResponse>

    /* Get one TV show by it's id */
    @GET("tv/{tv_id}/similar")
    fun getSerieLiees(@Path("tv_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<SeriesResponse>
    /* Get details of serie in order to get number of seasons and episodes */
    @GET("tv/{tv_id}")
    fun getDetails(@Path("tv_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<DetailsSerie>


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