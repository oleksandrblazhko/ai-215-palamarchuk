package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class CleaningParam(
    val kValue: Float,
    val rustValue: Float,
    val saltValue: Float,
    val sandValue: Float,
    val naValue: Float,
    val feValue: Float
) : Parcelable