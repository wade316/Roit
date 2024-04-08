package com.example.retrofitstudy

import com.example.retrofitstudy.DTO.LeagueEntryDTOItem
import com.example.retrofitstudy.DTO.MatchDTO
import com.example.retrofitstudy.DTO.MatchPuuidDTO
import com.example.retrofitstudy.DTO.SummonerrDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val REST_API_KEY = "RGAPI-30df5c25-294f-45b7-9966-f1e926d4f187"

interface RetrofitInterface {
    //닉네임으로 기본적인 정보 얻는 API
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}") //URL End Point
    suspend fun searchByQueryList(
        @Path("summonerName") summonerName: String,
        @Query("api_key") API_key: String = REST_API_KEY
    ): Response<SummonerrDTO>  /**isSuccessful을 하려면 Response를 써야하는데 이유는? 오류,성공 등을 표현하는 함수 판단은 issuccessfyl이 함*/

    //match에서 puuid로 matchId 얻는 API
    @GET("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    suspend fun matchPuuidList(
        @Path("puuid") puuid: String,
        @Query("api_key") API_key: String = REST_API_KEY
    ): Response<MatchPuuidDTO>

    //matchId로 매치 정보 얻는 API
    @GET("/lol/match/v5/matches/{matchId}")
    suspend fun matchInfoList(
        @Path("matchId") matchId: String,
        @Query("api_key") API_key: String = REST_API_KEY
    ): MatchDTO

    //summonerId로 리그 정보 얻는 API
    @GET("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    suspend fun leagueEntry(
        @Path("encryptedSummonerId") encryptedSummonerId: String,
        @Query("api_key") API_key: String = REST_API_KEY
    ): LeagueEntryDTOItem

    //puuid로 챔피언 숙련도 얻는 API
    @GET("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}")
    suspend fun championMastery(
        @Path("encryptedPUUID") puuid: String,
        @Query("api_key") API_key: String = REST_API_KEY
    )
}