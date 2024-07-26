package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class Text(
    val type: String,
    val caption: String,
    val attribute: String,
    val required: Boolean,
    val suggestions: List<String>
)