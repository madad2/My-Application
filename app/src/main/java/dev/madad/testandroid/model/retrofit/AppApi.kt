package dev.madad.testandroid.model.retrofit


import retrofit2.http.GET

interface AppApi {
    @GET("7f41b5d6d3b78838d35a9b504d21f2f0/raw/3e7f17e2cea043ad5d4179da7b884163c34f51d1/test.json")
    suspend fun getUiConfiguration(): String
}