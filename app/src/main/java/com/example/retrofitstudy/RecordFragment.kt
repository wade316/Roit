package com.example.retrofitstudy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofitstudy.Main.MainActivity
import com.example.retrofitstudy.Model.SearchModel
import com.example.retrofitstudy.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {
    lateinit var binding: FragmentRecordBinding
    private var item: List<SearchModel> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordBinding.inflate(inflater, container, false)
        binding.button2.setOnClickListener {
            val mainActivity = activity as MainActivity
            Log.d("RecordFragment", "API DATA = $item")
        }
        // Inflate the layout for this fragment

        return binding.root
    }

}

//class MainViewModel : ViewModel() {
//    fun add(searchModel: SearchModel) {
//        val currentList = _searchItems.value?.toMutableList() ?: mutableListOf()
//        currentList.add(searchModel)
//        _searchItems.value = currentList
//    }
//
//    private val _searchItems: MutableLiveData<List<SearchModel>> = MutableLiveData()
//    val searchItems: LiveData<List<SearchModel>> = _searchItems
//
//}

//class MainActivity : AppCompatActivity() {
//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
//
//    private val sharedViewModel by viewModels<MainViewModel>()
//
////    private val tabTextList = listOf("Profile", "Search", "Setting")
////    private val tabIconList = listOf(R.drawable.icon_profile, R.drawable.icon_search, R.drawable.icon_setting)
//
//    private val REST_API_KEY = "RGAPI-30df5c25-294f-45b7-9966-f1e926d4f187"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//        initViewPager()
//        binding.tvSearch.setOnClickListener {
//            val id = binding.editText.text.toString()
//            if (id.isNotEmpty()) {
//                retrofitapi(id)
//            }
//        }
//    }
//
//    private fun retrofitapi(id: String) {
//        lifecycleScope.launch {
//            val api =
//                RetrofitClient.apiService.searchByQueryList(summonerName = id, REST_API_KEY)
//            val level = api.summonerLevel
//            val name = api.name
//            val frofile = api.profileIconId
//            sharedViewModel.add(SearchModel(name,frofile,level))
//        }
//    }
//
//    private fun initViewPager() {
//        //ViewPager2 Adapter 셋팅
//        var viewPagerAdatper = ViewPagerAdapter(this)
//        viewPagerAdatper.addFragment(KdaFragment())
//        viewPagerAdatper.addFragment(RecordFragment())
//
//        //Adapter 연결
//        binding.viewPager01.apply {
//            adapter = viewPagerAdatper
//
////            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
////                override fun onPageSelected(position: Int) {
////                    super.onPageSelected(position)
////                }
////            })
//        }
//
//        //ViewPager, TabLayout 연결
//        TabLayoutMediator(binding.tabLayout, binding.viewPager01) { tab, position ->
//            Log.e("YMC", "ViewPager position: ${position}")
//            when (position) {
//                0 -> tab.text = "이번 시즌 메인 챔프 KDA"
//                1 -> tab.text = "최근전적"
//            }
//        }.attach()
//    }
//}