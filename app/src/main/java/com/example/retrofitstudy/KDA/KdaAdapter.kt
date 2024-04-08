package com.example.retrofitstudy.KDA

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.retrofitstudy.Model.LeagueEntryModel
import com.example.retrofitstudy.databinding.RvInfoItemBinding
import com.example.retrofitstudy.databinding.RvProfileItemBinding

//class KadAdapter(private var item: List<SearchModel> = ArrayList(),
//                 private val mContext: Context):RecyclerView.Adapter<KadAdapter.ProfileViewHolder>() {
//
//    interface SearchVideoClick {
//        fun onClick(item: SearchModel)
//    }
//
//    companion object{
//        const val TYPE_PROFILE = 0
//        const val TYPE_MATCH = 1
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
//        val binding = RvProfileItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ProfileViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return item.size
//    }
//
//    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
//        val currentItem = item[position]
//        holder.name.text = currentItem.name
//        holder.level.text = currentItem.level.toString()
//        holder.bind(item[position])
//    }
//
//    inner class ProfileViewHolder(binding: RvProfileItemBinding):RecyclerView.ViewHolder(binding.root),
//        View.OnClickListener{
//        val name = binding.tvUsername
//        val level = binding.tvLevel
//        val icon = binding.ivFrofile
//        fun bind(item: SearchModel){
//            name.text = item.name   //이너클래스 사용시 호출방법?
//            level.text = item.level.toString()
//            Glide.with(icon)
//                .load("https://ddragon.leagueoflegends.com/cdn/14.3.1/img/profileicon/${item.profile}.png")
//                .into(icon)
//
//        }
//
//        override fun onClick(v: View?) {
//        }
//    }

//    inner class MactchViewHolder(binding: RvInfoItemBinding):RecyclerView.ViewHolder(binding.root),
//        View.OnClickListener{
//            val kill = binding.tvKdaKill
//        fun bind(item: SummonerMatch.MatchInfoModel){
//            kill.
//        }
//        }

//}

class KdaAdapter(private val mContext: Context
): RecyclerView.Adapter<ViewHolder>() {

    private var item: MutableList<SummonerMatch> = mutableListOf()
    private var leagueitem: MutableList<LeagueEntryModel> = mutableListOf()

    interface SearchVideoClick {
        fun onClick(item: SummonerMatch.SummonerModel)
    }
    interface MatchInfoClick {
        fun onClick(item: SummonerMatch.MatchInfoModel)
    }

    companion object{
        const val TYPE_PROFILE = 0
        const val TYPE_MATCH = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        Log.d("sdc","KDA Adapter = $item")

        return when (viewType) {

            TYPE_PROFILE -> {
                val binding = RvProfileItemBinding.inflate(inflater, parent, false)
                ProfileViewHolder(binding)
            }
            TYPE_MATCH -> {
             val binding = RvInfoItemBinding.inflate(inflater,parent,false)
             MactchViewHolder(binding)
            }
//            TYPE_PROFILE -> ProfileViewHolder(LayoutInflater.from(parent.context).inflate(RvProfileItemBinding, parent, false))
//            TYPE_MATCH -> MactchViewHolder(LayoutInflater.from(parent.context).inflate(RvInfoItemBinding, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
        /** 기존코드
        val binding = RvProfileItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfileViewHolder(binding)
         */
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val item = item[position]) {
            is SummonerMatch.SummonerModel -> (holder as ProfileViewHolder).bind(item)
            is SummonerMatch.MatchInfoModel -> (holder as MactchViewHolder).bind(item)
            else -> {

            }
        }

        /** 기존코드
        val currentItem = item[position]
        holder.name.text = currentItem.name
        holder.level.text = currentItem.level.toString()
        holder.bind(item[position])
         */
    }
    fun additem(a: MutableList<SummonerMatch>) {
        item.addAll(a)
    }
    fun addleagueitem(b: MutableList<LeagueEntryModel>){
        leagueitem.addAll(b)
    }

    override fun getItemViewType(position: Int): Int {
        return if(item[position] is SummonerMatch.SummonerModel) TYPE_PROFILE else TYPE_MATCH
    }

    inner class ProfileViewHolder(binding: RvProfileItemBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        val name = binding.tvUsername
        val level = binding.tvLevel
        val icon = binding.ivFrofile
        val tier = binding.ivTier
        val rank = binding.tvLeaguepoint
        fun bind(item: SummonerMatch.SummonerModel){
            name.text = item.name   //이너클래스 사용시 호출방법?
            level.text = item.level.toString()
            rank.text = leagueitem.toString()
            Glide.with(icon)
                .load("https://ddragon.leagueoflegends.com/cdn/14.3.1/img/profileicon/${item.profile}.png")
                .into(icon)

        }

        override fun onClick(v: View?) {
        }
    }

    inner class MactchViewHolder(binding: RvInfoItemBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val kill = binding.tvKdaKill
        fun bind(item: SummonerMatch.MatchInfoModel) {
            kill.text = item.kill.toString()
        }

        override fun onClick(v: View?) {
        }
    }

}