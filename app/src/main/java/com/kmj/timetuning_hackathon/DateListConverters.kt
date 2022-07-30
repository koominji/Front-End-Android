package com.kmj.timetuning_hackathon

import androidx.room.TypeConverter
import com.google.gson.Gson

class DateListConverters {
    @TypeConverter
    fun listToJson(value: List<DateInfo>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<DateInfo>? {
        return Gson().fromJson(value,Array<DateInfo>::class.java)?.toList()
    }
}