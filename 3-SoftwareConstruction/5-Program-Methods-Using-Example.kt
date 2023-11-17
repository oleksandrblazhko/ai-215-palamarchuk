package com.example.watercleaningapp

import androidx.appcompat.app.AlertDialog

fun methodUsage() {
    val activity = MainActivity()
    val builder = AlertDialog.Builder(activity)
    when(activity.doReport(
        1F,1F,1F,1F,1F,1F,1
    )) {
        MainActivity.SUCCESS -> {
            builder.setTitle("Параметри успішно встановлені")
            builder.setPositiveButton("OK") { ignored1, ignored2 -> }
            builder.create().show()
        }
    }
    when(activity.doReport(
        1F,1F,1F,1F,1F,1F,-1
    )) {
        MainActivity.ID_ERROR -> {
            builder.setTitle("Погане ID")
            builder.setPositiveButton("OK") { ignored1, ignored2 -> }
            builder.create().show()
        }
    }
    when(activity.doReport(
        123F,1F,1F,1F,1F,1F,1
    )) {
        MainActivity.DATA_ERROR -> {
            builder.setTitle("Погані данниє")
            builder.setPositiveButton("OK") { ignored1, ignored2 -> }
            builder.create().show()
        }
    }
}