package dev.madad.testandroid.model.retrofit

import dev.madad.testandroid.model.models.config.UiConfig
import dev.madad.testandroid.model.models.user.UserResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("3e7f17e2cea043ad5d4179da7b884163c34f51d1/test.json")
    suspend fun getUiConfiguration(): UiConfig

    @GET
    suspend fun getUserInfo(@Url url: String): UserResponse
}