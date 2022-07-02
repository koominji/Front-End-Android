package com.kmj.timetuning_hackathon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kmj.timetuning_hackathon.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_updateplan.*


//신미림
class MainActivity : AppCompatActivity() {

    // lateinit var binding: ActivityMainBinding

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fl_container)
    }

    //lateinit var plan_plus : UpdatePlanFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val main_bnv = findViewById<BottomNavigationView>(R.id.main_bnv)

        main_bnv.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.updateplan -> {
                        main_bnv.itemIconTintList = ContextCompat.getColorStateList(this, R.color.purple_700)
                        main_bnv.itemTextColor = ContextCompat.getColorStateList(this, R.color.purple_700)
                        UpdatePlanFragment()
                        // Respond to navigation item 1 click
                    }
                    R.id.schedulecheck -> {
                        main_bnv.itemIconTintList = ContextCompat.getColorStateList(this, R.color.purple_700)
                        main_bnv.itemTextColor = ContextCompat.getColorStateList(this, R.color.purple_700)
                        ScheduleCheckFragment()
                        // Respond to navigation item 2 click
                    }
                    R.id.mypage -> {
                        main_bnv.itemIconTintList = ContextCompat.getColorStateList(this, R.color.purple_700)
                        main_bnv.itemTextColor = ContextCompat.getColorStateList(this, R.color.purple_700)
                        MyPageFragment()
                        // Respond to navigation item 3 click
                    }
                    else -> {
                        main_bnv.itemIconTintList = ContextCompat.getColorStateList(this, R.color.purple_700)
                        main_bnv.itemTextColor = ContextCompat.getColorStateList(this, R.color.purple_700)
                        UpdatePlanFragment()
                    }
                }
            )
            true
        }
        main_bnv.selectedItemId = R.id.updateplan
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }




    }



















