package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class UiConfig(
    val activities: List<Activity>
)