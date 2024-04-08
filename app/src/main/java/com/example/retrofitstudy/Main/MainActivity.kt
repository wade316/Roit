package com.example.retrofitstudy.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.retrofitstudy.DTO.MatchPuuidDTO
import com.example.retrofitstudy.KDA.KdaFragment
import com.example.retrofitstudy.KDA.SummonerMatch
import com.example.retrofitstudy.Model.LeagueEntryModel
import com.example.retrofitstudy.RecordFragment
import com.example.retrofitstudy.RetrofitClientAsia
import com.example.retrofitstudy.RetrofitClientKr
import com.example.retrofitstudy.ViewPagerAdapter
import com.example.retrofitstudy.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
//    val searchItems: MutableList<SearchModel> = mutableListOf()

    private val sharedViewModel by viewModels<MainViewModel>()

//    private val tabTextList = listOf("Profile", "Search", "Setting")
//    private val tabIconList = listOf(R.drawable.icon_profile, R.drawable.icon_search, R.drawable.icon_setting)

//    private val REST_API_KEY = "RGAPI-30df5c25-294f-45b7-9966-f1e926d4f187"

    override fun onBackPressed() {
        super.onBackPressed()   //super는 해당 오버라이드가 실행될때 정상 작동하는
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewPager()
        binding.tvSearch.setOnClickListener {
            val id = binding.editText.text.toString()
            if (id.isNotEmpty()) {
                summonerApi(id)
            }
        }
    }


    /**
     * 코루틴을 이용한 API 연쇄 호출
    CoroutineScope(Dispatchers.IO).launch {
        val result1 = apiService.call1Api().await()   //callApi는 호출 함수명,await은 끝날때까지 기다리라는것
        if (result1.isSuccessful) {
            val result2 = apiService.call2Api(result1.uid).await()
            if (result2.isSuccessful) {
            }
        }
    }
     */
    private fun summonerApi(id: String) {
            lifecycleScope.launch {
                val summonerapi =
                    RetrofitClientKr.apiService.searchByQueryList(summonerName = id)
//            if(summonerapi.isSuccessful) {

                /**호출부분에서 Response을 하면 body가 붙는데 이유는?
                 * isSuccessful을 쓰려면 Responese를 써야하는데 꼭 써야하는지?
                 * Response는 예외처리할때 쓰이고 runcaching과 비슷하
                 * Response는 insuccessful을 할수있어서 흐름제어를 할수있고
                 * runcaching은 오류 발생하는것에대한 것이기 때문에 예외처리만 가능하다
                 * Response는 오류,성공 등을 표현하는 함수 판단은 issuccessfyl이 함
                 * 상황에 맞게 쓰면 됨*/
                val level = summonerapi.body()?.summonerLevel
                val name = summonerapi.body()?.name
                val profile = summonerapi.body()?.profileIconId
                val puuid = summonerapi.body()?.puuid.toString()
                val summonerId = summonerapi.body()?.id
                sharedViewModel.add(SummonerMatch.SummonerModel(name.toString(), profile, level))
                if (summonerapi.isSuccessful) {
                    val matchpuuid =
                        RetrofitClientAsia.apiService.matchPuuidList(puuid)

                    leagueEntry(summonerId.toString())
//                    val league =
//                        RetrofitClientKr.apiService.leagueEntry(summonerId.toString())
//                    val rank = league.rank
//                    val tier = league.tier
//                    sharedViewModel.add(LeagueEntryModel(rank,tier))

                    Log.d("sdc", "matchPuuid = ${matchpuuid}")
                    if (matchpuuid.isSuccessful) {
                        match(matchpuuid)
                    }
                }
            }
    }
    //호출하는데 에러남 결과는 200으로 정상으로 받은거 확임됨
    private fun leagueEntry(summonerId: String){
        lifecycleScope.launch {
            val league =
            RetrofitClientKr.apiService.leagueEntry(summonerId)
            val rank = league.rank
            val tier = league.tier
            sharedViewModel.add(LeagueEntryModel(rank,tier))
        }
    }

    private suspend fun match(matchpuuid: Response<MatchPuuidDTO>){
        lifecycleScope.launch {
            matchpuuid.body()?.forEach { i ->
                val matchList =
                    RetrofitClientAsia.apiService.matchInfoList(i)
                Log.d("sdc", "matchinfo = $matchList")
                val champIcon = matchList.info.participants[0].championName
                val kill = matchList.info.participants[0].kills
                val summonerId = matchList.info.participants[0].summonerId
                sharedViewModel.add(SummonerMatch.MatchInfoModel(kill, summonerId, champIcon))
            }
        }
    }

    private fun matchPuuid(puuid: String){
        lifecycleScope.launch {
//            val matchpuuid = RetrofitClient.apiService.
        }
    }

    private fun initViewPager() {
        //ViewPager2 Adapter 셋팅
        val viewPagerAdatper = ViewPagerAdapter(this)
        viewPagerAdatper.addFragment(KdaFragment())//2개넣어주고
        viewPagerAdatper.addFragment(RecordFragment())

        //Adapter 연결
        //탭레이아웃 클릭시 프레그먼트 전환
        binding.viewPager01.apply {
            adapter = viewPagerAdatper

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        //ViewPager, TabLayout 연결
        //텍스트설정부분
        TabLayoutMediator(binding.tabLayout, binding.viewPager01) { tab, position ->
            Log.e("YMC", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "이번 시즌 메인 챔프 KDA"
                1 -> tab.text = "최근전적"
            }
        }.attach()
    }
}