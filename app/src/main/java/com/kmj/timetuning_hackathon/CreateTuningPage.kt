package com.kmj.timetuning_hackathon

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import com.applikeysolutions.cosmocalendar.model.Day
import com.applikeysolutions.cosmocalendar.selection.OnDaySelectedListener
import com.applikeysolutions.cosmocalendar.selection.RangeSelectionManager
import com.kmj.timetuning_hackathon.databinding.ActivityCreateTuningPageBinding
import dev.sasikanth.colorsheet.ColorPickerListener
import dev.sasikanth.colorsheet.ColorSheet
import dev.sasikanth.colorsheet.utils.ColorSheetUtils
import java.util.*
import java.util.Date
import kotlin.collections.ArrayList

class CreateTuningPage : AppCompatActivity() {
    lateinit var binding: ActivityCreateTuningPageBinding
    lateinit var dates: List<Day>
    lateinit var selectedDates: List<DateInfo>
    lateinit var newScheduleDB: NewScheduleDatabase

    var colorName: Int = -6700810

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTuningPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 캘린더 화면으로 전환
        binding.createAddDateCv.setOnClickListener {
            Log.d("clicked", "clicked")
            binding.createContentCl.visibility = View.INVISIBLE
            binding.createCalendarCl.visibility = View.VISIBLE

        }

        // 뒤로가기 버튼
        binding.createBackIv.setOnClickListener {
            finish()
        }

        // 색깔 설정 colorPicker
        binding.createColorPicker.setOnClickListener {
            setColor()
        }

        // 캘린더에서 기간 설정 후 => '선택완료' 버튼 클릭
        binding.calendarSelectCompleteBtn.setOnClickListener {

            if (binding.calendarView.selectedDates.size <= 0) {
                Toast.makeText(this, "날짜를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                getSelectedDates()
            }

            Log.d("selected dates", "${binding.calendarView.selectedDays}")

        }

        binding.calendarView.isShowDaysOfWeekTitle = false
        binding.calendarView.selectionManager = RangeSelectionManager(OnDaySelectedListener {
            if (binding.calendarView.selectedDates.size <= 0) return@OnDaySelectedListener
            Log.d("selected dates", "${binding.calendarView.selectedDays}")
        })

        // 확인 버튼 클릭
        binding.createConfirmBtn.setOnClickListener {
            // 입력된 '일정 제목', '일정 설명', '날짜 list' 를 받아서 roomDB에 넣음
            val title = binding.createTitleEt.text.toString()
            val describe = binding.createDescribeEt.text.toString()

            newScheduleDB = NewScheduleDatabase.getInstance(this)!!
            Log.d("insertInfo", "${title},${describe}")

            if (title == ""|| describe == "" ||selectedDates.isEmpty()) {
                Log.d("insertInfo", "${title},${describe}")
                Toast.makeText(this, "정보를 바르게 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                newScheduleDB.newScheduleDao()
                    .insert(NewSchedule(title, describe, selectedDates, colorName))
                Log.d("DB:getAll", newScheduleDB.newScheduleDao().getAll().toString())

                finish()
            }

        }

    }

    // 색깔 설정
    private fun setColor() {

        val colors = resources.getIntArray(R.array.colors)
        ColorSheet().colorPicker(

            colors = colors,
            listener = { color ->
                // Handle color
                binding.createColorPicker.backgroundTintList = ColorStateList.valueOf(color)
                Log.d("colorInt", "${color}")
                Log.d("colorString", ColorSheetUtils.colorToHex(color))
                colorName = color
            })
            .show(supportFragmentManager)

    }


    // 선택된 날짜 List로 받아오기, recyclerView 출력
    private fun getSelectedDates() {

        selectedDates = emptyList<DateInfo>()

        binding.createContentCl.visibility = View.VISIBLE
        binding.createCalendarCl.visibility = View.INVISIBLE
        binding.createAddDateIv.visibility = View.INVISIBLE
        binding.createAddDateCv.setBackgroundColor(Color.TRANSPARENT)

        // 선택된 dates
        dates = binding.calendarView.selectedDays

        // 선택된 각 date의 year,month,day,dayOfWeek
        for (date in dates) {
            val year = date.calendar.get(Calendar.YEAR)
            val month = date.calendar.get(Calendar.MONTH) + 1
            val day = date.calendar.get(Calendar.DAY_OF_MONTH)
            val dayOfWeek = date.calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.LONG_FORMAT,
                Locale.KOREAN
            )

            selectedDates += (DateInfo(year, month, day, dayOfWeek))

        }

        // 선택된 날짜 recyclerview
        val selectedDatesRVAdapter = SelectedDatesRVAdapter(selectedDates)
        binding.createSelectedDateRv.adapter = selectedDatesRVAdapter

        val selectedDatesLayoutManager = LinearLayoutManager(this)
        selectedDatesLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.createSelectedDateRv.layoutManager = selectedDatesLayoutManager
    }

}