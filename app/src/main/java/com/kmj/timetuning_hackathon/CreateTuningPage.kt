package com.kmj.timetuning_hackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmj.timetuning_hackathon.databinding.ActivityCreateTuningPageBinding

class CreateTuningPage : AppCompatActivity() {
    lateinit var binding:ActivityCreateTuningPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTuningPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAddDateIv.setOnClickListener {
            val intent = Intent(this,CalendarActivity::class.java)
            startActivity(intent)
        }

    }
}