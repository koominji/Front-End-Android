package com.kmj.timetuning_hackathon

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.kmj.timetuning_hackathon.databinding.ActivityPlanInfoBinding


// 6. 생성된 일정정보 확인 페이지
class PlanInfoActivity:AppCompatActivity(){
    private var gson: Gson = Gson()
    lateinit var binding:ActivityPlanInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlanInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newScheduleObj = intent.getStringExtra("newSchedule")
        val newSchedule = gson.fromJson(newScheduleObj, NewSchedule::class.java)

        setInit(newSchedule)

        // 뒤로가기 버튼
        binding.planInfoBackIv.setOnClickListener {
            finish()
        }

        // 일정확정하기 버튼
        binding.planInfoConfirmBtn.setOnClickListener {
            val dialog = PlanInfoDialog(newSchedule.id)
            // 알림창이 띄워져있는 동안 배경 클릭 막기
            dialog.isCancelable = false
            dialog.show(this.supportFragmentManager, "ConfirmDialog")
        }
    }

    // 화면 최초 지정
    private fun setInit(newSchedule: NewSchedule){

        binding.planInfoTitleTv.text=newSchedule.title // title
        binding.planInfoDescribeTv.text=newSchedule.describe // describe

        // 선택된 날짜 recyclerview
        val selectedDatesRVAdapter = SelectedDatesRVAdapter(newSchedule.selectedDates)
        binding.planINfoSelectedDateRv.adapter = selectedDatesRVAdapter

        val selectedDatesLayoutManager = LinearLayoutManager(this)
        selectedDatesLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.planINfoSelectedDateRv.layoutManager = selectedDatesLayoutManager

        // 색깔 지정
        binding.planInfoColorPicker.backgroundTintList= ColorStateList.valueOf(newSchedule.color)

    }
}

