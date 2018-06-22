package app.youcef.com.stock2.APIs

/**
 * Created by hp on 19/06/2018.
 */
import app.youcef.com.stock2.Model.ActeurResponse
import app.youcef.com.stock2.Model.DetailsPersonne
import app.youcef.com.stock2.Constants.ApiParam.baseURL
import app.youcef.com.stock2.Constants.ApiParam.urlActeurs
import app.youcef.com.stock2.Constants.ApiParam.urlDetailsActeur
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
interface ActeurAPIClient {

    /* Get list of acteurs */
    @GET(urlActeurs)
    fun getLesActeurs(@Query("api_key") api_key: String): Observable<ActeurResponse>

    /* Get one acteur by it's id */
    @GET(urlActeurs)
    fun getUnActeur(@Query("api_key") api_key: String): Observable<ActeurResponse>
    @GET(urlDetailsActeur)
    fun getDetails(@Path("person_id") tv_id:Int ,@Query("api_key") api_key: String): Observable<DetailsPersonne>

    companion object {

        fun create(): ActeurAPIClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseURL)
                    .build()

            return retrofit.create(ActeurAPIClient::class.java)

        }
    }

}