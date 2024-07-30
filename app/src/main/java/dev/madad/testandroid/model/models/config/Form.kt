package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Form(
    @SerialName("buttons")
    val buttons: List<Button>,
    @SerialName("text")
    val text: List<Text>
)