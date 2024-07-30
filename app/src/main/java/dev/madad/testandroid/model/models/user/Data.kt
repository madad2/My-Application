package dev.madad.testandroid.model.models.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("user")
    val user: User
)