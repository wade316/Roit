package com.example.retrofitstudy.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LeagueEntryModel(
    val rank: String,
    val tier: String,
): Parcelable
