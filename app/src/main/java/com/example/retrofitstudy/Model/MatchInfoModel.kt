package com.example.retrofitstudy.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchInfoModel(
    //Participant 하위
    val kill: Int,
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


): Parcelable
