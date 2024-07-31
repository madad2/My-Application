package dev.madad.testandroid.model.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json

object RetrofitClient {
    private const val BASE_URL = "https://gist.githubusercontent.com/vth2k/7f41b5d6d3b78838d35a9b504d21f2f0/raw/"

    fun create(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
        return retrofit.create(ApiService::class.java)
    }
}