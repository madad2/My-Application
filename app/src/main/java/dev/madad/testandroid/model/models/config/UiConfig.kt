package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UiConfig(
    @SerialName("activities")
    val activities: List<Activity>
)