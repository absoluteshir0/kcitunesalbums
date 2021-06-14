package sn.nino.kcitunesalbums.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import sn.nino.kcitunesalbums.BuildConfig

// create the instance of Retrofit
interface Api {
    @GET("search")
    fun getAlbums(
        @Query("term") term: String?,
        @Query("amp;country") country: String?,
        @Query("amp;media") media: String?,
        @Query("amp:all") all: String?
    ): Call<ApiResponse?>

    companion object {

        private var BASE_URL = "https://itunes.apple.com/"
        fun create() : Api {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(getLogInterceptorClient())
                .build()

            return retrofit.create(Api::class.java)

        }

        private fun getLogInterceptorClient(): OkHttpClient {
            val clientBuilder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {    //Enable API logs in debug mode
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                clientBuilder.addInterceptor(interceptor)
            }
            return clientBuilder.build()
        }
    }
}