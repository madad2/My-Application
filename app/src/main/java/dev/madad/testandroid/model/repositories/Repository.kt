package dev.madad.testandroid.model.repositories

import dev.madad.testandroid.model.models.UiConfig
import dev.madad.testandroid.model.models.UserInfo
import dev.madad.testandroid.model.retrofit.AppApi

interface Repository {
    suspend fun getUiConfig(): UiConfig
    suspend fun getUserInfo(url: String): UserInfo
}

class MainRepository(private val api: AppApi) : Repository {
    override suspend fun getUiConfig() = api.getUiConfiguration()

    override suspend fun getUserInfo(url: String): UserInfo = api.getUserInfo(url)
}