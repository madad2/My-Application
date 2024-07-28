package dev.madad.testandroid.model.retrofit


import dev.madad.testandroid.model.models.UserInfo
import dev.madad.testandroid.model.models.UiConfig
import retrofit2.http.GET
import retrofit2.http.Url

interface AppApi {
    @GET("vth2k/7f41b5d6d3b78838d35a9b504d21f2f0/raw/3e7f17e2cea043ad5d4179da7b884163c34f51d1")
    suspend fun getUiConfiguration(): UiConfig

    @GET
    suspend fun getUserInfo(@Url url: String): UserInfo
}