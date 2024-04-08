package com.example.retrofitstudy.KDA

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.retrofitstudy.Main.MainViewModel
import com.example.retrofitstudy.databinding.FragmentKdaBinding

class KdaFragment : Fragment() {
    lateinit var binding: FragmentKdaBinding
    private lateinit var adapter: KdaAdapter
    private lateinit var mContext: Context
    private var infoItems:MutableList<SummonerMatch> = mutableListOf()
    private val sharedViewModel by activityViewModels<MainViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKdaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        메인에 있는 리스트를 fragment리스트로 넣는과정
//        val mainActivity = activity as MainActivity
//        searchItems = mainActivity.searchItems

//        MainViewModel에 라이브데이터가 변경을 감지하고 변경됐을때 adapter에 연결
//        adapter를 계속 갱신할 필요가 없으니 연결방식을 바꿔주는걸 추후에 생각해보기
        sharedViewModel.searchItems.observe(viewLifecycleOwner){
            adapter.additem(it.toMutableList())
            adapter.notifyDataSetChanged()   //멀티뷰 할때 다른리스트를 사용해야할땐 리스트를 어떻게 치리하는지?
            Log.d("KDAfragment","List = ${it}")
        }
        sharedViewModel.matchInfo.observe(viewLifecycleOwner){
            adapter.additem(it.toMutableList())
            adapter.notifyDataSetChanged()
        }
        sharedViewModel.leagueEntry.observe(viewLifecycleOwner){
            adapter.addleagueitem(it.toMutableList())
        }
        adapter = KdaAdapter(mContext)
        binding.rvKda.adapter = adapter
    }
}