package com.example.retrofitstudy.Main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitstudy.KDA.SummonerMatch
import com.example.retrofitstudy.Model.ChampionMasteryModel
import com.example.retrofitstudy.Model.LeagueEntryModel

class MainViewModel : ViewModel() {

    private val _searchItems: MutableLiveData<List<SummonerMatch>> = MutableLiveData()
    val searchItems: LiveData<List<SummonerMatch>> = _searchItems

    private val _matchInfo: MutableLiveData<List<SummonerMatch>> = MutableLiveData()
    val matchInfo : LiveData<List<SummonerMatch>> = _matchInfo

    private val _championMastery: MutableLiveData<List<ChampionMasteryModel>> = MutableLiveData()
    val championMastery : LiveData<List<ChampionMasteryModel>> = _championMastery

    private val _leagueEntry: MutableLiveData<List<LeagueEntryModel>> = MutableLiveData()
    val leagueEntry : LiveData<List<LeagueEntryModel>> = _leagueEntry
    // 라이브데이타는 옵저빙, 스테이트플로우

    //    오류를 더이상 안알려주게 하는
    @SuppressLint("SuspiciousIndentation") //clear를 추가하니까 오류해결책으로 뜬거임 어떤 역할인지 모름
    fun add(searchModel: SummonerMatch.SummonerModel) {
        val currentList = _searchItems.value?.toMutableList() ?: mutableListOf()
            currentList.clear()
            currentList.add(searchModel)
            _searchItems.value = currentList
    }

    fun add(matchInfoModel: SummonerMatch) {
        val currentList = _matchInfo.value?.toMutableList() ?: mutableListOf()
        currentList.add(matchInfoModel)
        _matchInfo.value = currentList
        Log.d("sdc", "cruunetList = $currentList")
    }

    fun add(championMastery: ChampionMasteryModel){
        val currrentList = _championMastery.value?.toMutableList() ?: mutableListOf()
        currrentList.add(championMastery)
        _championMastery.value = currrentList
    }

    fun add(leagueEntry: LeagueEntryModel){
        val currentList = _leagueEntry.value?.toMutableList() ?: mutableListOf()
        currentList.add(leagueEntry)
        _leagueEntry.value = currentList
    }
}