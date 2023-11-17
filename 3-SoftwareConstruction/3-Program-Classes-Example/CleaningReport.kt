package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CleaningReport(
    val id: Int,
    val uid: Int,
    val body: Float,
    val recommendation: String
) : Parcelable