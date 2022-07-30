package com.kmj.timetuning_hackathon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.kmj.timetuning_hackathon.databinding.FragmentUpdateplanBinding



class UpdatePlanFragment : Fragment() {

    private lateinit var plan_plus: Button
    private var scheduleList = ArrayList<NewSchedule>()
    lateinit var newScheduleDB: NewScheduleDatabase

    lateinit var binding: FragmentUpdateplanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateplanBinding.inflate(inflater, container, false)

        // 데이터 리스트 생성 더미 데이터
        newScheduleDB = NewScheduleDatabase.getInstance(requireContext())!!

        Log.d("LC:onCreateView","$scheduleList")

        return binding.root

    }


    override fun onStart() {
        scheduleList.clear()
        scheduleList.addAll(newScheduleDB.newScheduleDao().getAll())

        initUpdatePlanRV()

        Log.d("LC:onStart", "$scheduleList")

        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plan_plus = view.findViewById(R.id.plan_plus)

        plan_plus.setOnClickListener {
            val intent = Intent(context, CreateTuningPage::class.java)
            startActivity(intent)
        }

    }

    private fun initUpdatePlanRV() {

        if (scheduleList.size == 0) {
            binding.updateplanNullTv.visibility = View.VISIBLE
            Log.d("??????", "size=0")

        } else {
            binding.updateplanNullTv.visibility = View.INVISIBLE
            Log.d("??????", "size>0")

            // recyclerview 출력
            val scheduleTunedRVAdapter = ScheduleTunedRVAdapter(scheduleList)
            binding.updateplanScheduleRv.adapter = scheduleTunedRVAdapter

            val scheduleTunedLayoutManager = LinearLayoutManager(requireContext())
            scheduleTunedLayoutManager.orientation = LinearLayoutManager.VERTICAL
            binding.updateplanScheduleRv.layoutManager = scheduleTunedLayoutManager



            scheduleTunedRVAdapter.setMyItemClickListener(object : ScheduleTunedRVAdapter.MyItemClickListener {

                override fun onItemClick(newSchedule: NewSchedule) {
                    Log.d("??", "onItemClicked")
                    changePlanInfoActivity(newSchedule)
                }
            })

        }

    }

    private fun changePlanInfoActivity(newSchedule: NewSchedule) {

        val intent = Intent(context,PlanInfoActivity::class.java)

        val gson = Gson()
        val newScheduleJson = gson.toJson(newSchedule)
        intent.putExtra("newSchedule", newScheduleJson)
        startActivity(intent)

    }


}