package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Layout(
    @SerialName("form")
    val form: Form,
    @SerialName("header")
    val header: String
)