package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReportBuilder(
    val recomendations: String,
    val dare: Date,
    val body: String,
    val user: User,
    val reportParams: String,
    val id: Int
) : Parcelable
