package dev.madad.testandroid.model.models.config


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Text(
    @SerialName("attribute")
    val attribute: String,
    @SerialName("caption")
    val caption: String,
    @SerialName("required")
    val required: Boolean,
    @SerialName("suggestions")
    val suggestions: List<String> = emptyList(),
    @SerialName("type")
    val type: String
)