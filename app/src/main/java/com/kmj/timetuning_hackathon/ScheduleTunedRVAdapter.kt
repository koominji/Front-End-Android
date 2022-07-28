package com.kmj.timetuning_hackathon

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmj.timetuning_hackathon.databinding.ScheduleListRvItemBinding

class ScheduleTunedRVAdapter(val scheduleInfo: List<NewSchedule>):
    RecyclerView.Adapter<ScheduleTunedRVAdapter.ViewHolder>() {

    // 클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onItemClick(newSchedule: NewSchedule)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }


    inner class ViewHolder(val binding: ScheduleListRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(scheduleInfo: NewSchedule) {

            binding.scheduleTitleTv.text=scheduleInfo.title
            binding.scheduleNamesTv.text=scheduleInfo.describe
            binding.selectedColor.backgroundTintList=ColorStateList.valueOf(scheduleInfo.color.toInt())
            binding.selectedColorCircle.backgroundTintList=ColorStateList.valueOf(scheduleInfo.color.toInt())

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ScheduleTunedRVAdapter.ViewHolder {
        val binding: ScheduleListRvItemBinding = ScheduleListRvItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleTunedRVAdapter.ViewHolder, position: Int) {
        val binding = (holder as ScheduleTunedRVAdapter.ViewHolder).binding
        holder.bind(scheduleInfo[position])
        binding.scheduleRvItemRoot.setOnClickListener {
            Log.d("clicked", "${position}")
        }

        // itemView의 클릭이벤트
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(scheduleInfo[position])
        }

    }

    override fun getItemCount(): Int = scheduleInfo.size
}

