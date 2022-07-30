package com.kmj.timetuning_hackathon

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewSchedule(
    val title: String,
    val describe: String,
    val selectedDates: List<DateInfo>,
    val color:Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
