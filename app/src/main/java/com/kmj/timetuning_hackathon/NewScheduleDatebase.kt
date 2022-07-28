package com.kmj.timetuning_hackathon

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [NewSchedule::class],version = 1)
@TypeConverters(DateListConverters::class)

abstract class NewScheduleDatabase : RoomDatabase() {
    abstract fun newScheduleDao():NewScheduleDao

    companion object{
        private var instance : NewScheduleDatabase? = null
        @Synchronized
        fun getInstance(context: Context):NewScheduleDatabase?{
            if(instance==null){
                synchronized(NewScheduleDatabase::class){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        NewScheduleDatabase::class.java,
                        "newSchedule-database" //다른 데이터 베이스랑 이름 겹치면 꼬인다
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}