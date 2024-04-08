package com.example.retrofitstudy

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientAsia {//베이스 URL이 다를땐 Client를 두개만드는지 아니면 어떻게 해야하는지?
    private const val BASE_URL = "https://asia.api.riotgames.com/lol/"
    // API 서비스 객체를 반환한다.
    val apiService: RetrofitInterface
        get() = instance.create(RetrofitInterface::class.java)

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    // Retrofit 인스턴스를 초기화하고 반환한다.
    private val instance: Retrofit
        private get() {
            // Gson 객체 생성. setLenient()는 JSON 파싱이 좀 더 유연하게 처리되도록 한다.
            val gson = GsonBuilder().setLenient().create()

            // Retrofit 빌더를 사용하여 Retrofit 인스턴스 생성
            return Retrofit.Builder()
                .baseUrl(BASE_URL)  // 기본 URL 설정
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(createOkHttpClient())// JSON 파싱을 위한 컨버터 추가
                .build()
        }
}