package com.dicoding.makananlezatnusantara

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name: String,
    val description: String,
    val historical: String,
    val photo: String
) : Parcelable
