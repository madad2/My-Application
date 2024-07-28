package dev.madad.testandroid.model.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val fullName: String,
    val position: String,
    val workHoursInMonth: Int,
    val workedOutHours: Int
)
