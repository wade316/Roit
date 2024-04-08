package com.example.retrofitstudy.DTO

import com.google.gson.annotations.SerializedName

data class LeagueEntryDTOItem(
    val freshBlood: Boolean,
    val hotStreak: Boolean,
    val inactive: Boolean,
    val leagueId: String,
    val leaguePoints: Int,
    val losses: Int,
    val queueType: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("summonerId")
    val summonerId: String,
    @SerializedName("summonerName")
    val summonerName: String,
    @SerializedName("tier")
    val tier: String,
    val veteran: Boolean,
    val wins: Int
)