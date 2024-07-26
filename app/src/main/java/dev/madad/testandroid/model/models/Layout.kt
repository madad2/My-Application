package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class Layout(
    val header: String,
    val form: Form
)