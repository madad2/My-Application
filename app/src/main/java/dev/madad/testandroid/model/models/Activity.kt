package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    val activity: String,
    val layout: Layout
)