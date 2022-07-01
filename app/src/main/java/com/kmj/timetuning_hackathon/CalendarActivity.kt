package com.kmj.timetuning_hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmj.timetuning_hackathon.databinding.ActivityCalendarBinding

class CalendarActivity : AppCompatActivity() {
    lateinit var binding:ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }
}