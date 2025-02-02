package com.example.retrofitstudy.DTO

import com.google.gson.annotations.SerializedName

data class SummonerrDTO(
    @SerializedName("accountId")
    val accountId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profileIconId")
    val profileIconId: Int,
    @SerializedName("puuid")
    val puuid: String,
    @SerializedName("revisionDate")
    val revisionDate: Long,
    @SerializedName("summonerLevel")
    val summonerLevel: Int
)