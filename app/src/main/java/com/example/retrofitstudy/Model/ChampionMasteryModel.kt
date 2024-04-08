package com.example.retrofitstudy.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChampionMasteryModel(
    val championId: Int,
    val championLevel: Int,
    val championPoints: Int,
    ): Parcelable
