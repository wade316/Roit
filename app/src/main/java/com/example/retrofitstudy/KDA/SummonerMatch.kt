package com.example.retrofitstudy.KDA


sealed class SummonerMatch {

    data class SummonerModel(
        val name: String,
        val profile: Int?,
        val level: Int?
    ): SummonerMatch()

    data class MatchInfoModel(
        //Participant 하위
        val kill: Int,
        val summonerId: String,
//    val death: Int,
//    val assist: Int,
//    val kda: Double,
//    val lane: String,
//    val totalMinionsKilled: Int,
//    val goldPerMinute: Double,
////    val profileIcon: Int,
////    val spell1Casts: Int,
////    val spell2Casts: Int,
////    val spell3Casts: Int,
////    val spell4Casts: Int,
//    val item0: Int,
//    val item1: Int,
//    val item2: Int,
//    val item3: Int,
//    val item4: Int,
//    val item5: Int,
//    val item6: Int,
//    val itemsPurchased: Int,
//    val champLevel: Int,
//    //ban 하위
        val championName: String,
//    val pickTurn: Int,
//    val win: Boolean


    ): SummonerMatch()
}
