package dev.madad.testandroid.model.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val data: Data,
    @Contextual
    val error: Error
)
