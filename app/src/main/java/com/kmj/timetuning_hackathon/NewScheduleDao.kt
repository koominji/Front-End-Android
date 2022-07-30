package com.kmj.timetuning_hackathon

import androidx.room.*

@Dao
interface NewScheduleDao {
    @Insert
    fun insert(newSchedule: NewSchedule)

    @Update
    fun update(newSchedule: NewSchedule)

    @Delete
    fun delete(newSchedule: NewSchedule)

    @Query("SELECT * FROM NewSchedule")
    fun getAll() : List<NewSchedule>
}