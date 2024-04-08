package com.example.retrofitstudy.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
    data class SearchModel(
        val name: String,
        val profile: Int?,
        val level: Int?
    ) : Parcelable