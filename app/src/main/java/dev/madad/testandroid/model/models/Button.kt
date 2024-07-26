package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class Button(
    val type: String,
    val caption: String,
    val formAction: String
)