package com.example.retrofitstudy.DTO

import com.google.gson.annotations.SerializedName

data class ChampionMasteryDtoItem(
    @SerializedName("championId")
    val championId: Int,
    @SerializedName("championLevel")
    val championLevel: Int,
    @SerializedName("championPoints")
    val championPoints: Int,
    val championPointsSinceLastLevel: Int,
    val championPointsUntilNextLevel: Int,
    val chestGranted: Boolean,
    val lastPlayTime: Long,
    val puuid: String,
    val summonerId: String,
    val tokensEarned: Int
)