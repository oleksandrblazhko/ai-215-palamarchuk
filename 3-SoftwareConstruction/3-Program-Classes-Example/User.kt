package com.example.watercleaningapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: Int,
    val login: String,
    val password: String
) : Parcelable