package dev.madad.testandroid.model.models.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("data")
    val `data`: Data,
    @SerialName("error")
    val error: Error
)