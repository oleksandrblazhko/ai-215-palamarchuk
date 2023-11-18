package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Report (
    val id: Int,
    val user: User,
    val cleaningParams: List<CleaningParams>,
    val report: String
) : Parcelable
