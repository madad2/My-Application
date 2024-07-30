package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    @SerialName("activity")
    val activity: String,
    @SerialName("layout")
    val layout: Layout
)