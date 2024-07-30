package dev.madad.testandroid.model.models.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("fullName")
    val fullName: String,
    @SerialName("position")
    val position: String,
    @SerialName("workHoursInMonth")
    val workHoursInMonth: Int,
    @SerialName("workedOutHours")
    val workedOutHours: Int
)