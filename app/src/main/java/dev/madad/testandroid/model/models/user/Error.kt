package dev.madad.testandroid.model.models.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error(
    @SerialName("description")
    val description: String,
    @SerialName("isError")
    val isError: Boolean
)