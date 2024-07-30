package dev.madad.testandroid.model.repositories

import dev.madad.testandroid.model.models.config.UiConfig
import dev.madad.testandroid.model.models.user.UserResponse
import dev.madad.testandroid.model.retrofit.ApiService

interface Repository {
    suspend fun getUiConfig(): UiConfig
    suspend fun getUserInfo(url: String): UserResponse
}

class MainRepository(private val api: ApiService) : Repository {
    override suspend fun getUiConfig() = api.getUiConfiguration()

    override suspend fun getUserInfo(url: String): UserResponse = api.getUserInfo(url)
}