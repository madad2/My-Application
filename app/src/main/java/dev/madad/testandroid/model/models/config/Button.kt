package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Button(
    @SerialName("caption")
    val caption: String,
    @SerialName("formAction")
    val formAction: String,
    @SerialName("type")
    val type: String
)