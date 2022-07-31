package com.kmj.timetuning_hackathon

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="UserTable")
data class User(
    val id : String,
    val password : String,
    val username : String
){
    @PrimaryKey(autoGenerate = true) var number : Int = 0
}
