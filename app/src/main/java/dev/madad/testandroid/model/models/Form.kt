package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class Form(
    val text: List<Text>,
    val buttons: List<Button>
)