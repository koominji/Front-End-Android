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


//신미림
class MainActivity : AppCompatActivity() {

    // lateinit var binding: ActivityMainBinding
    private lateinit var update_btn: Button

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fl_container)
    }

    //lateinit var plan_plus : UpdatePlanFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 스플래쉬 화면 설정
        setTheme(R.style.Theme_TimeTuning_hackathon)

        setContentView(R.layout.activity_main)



        val main_bnv = findViewById<BottomNavigationView>(R.id.main_bnv)


        //update_btn = fragment_schedulecheck.findViewById(R.id.btn_update_plan_button)


//        update_btn.setOnClickListener {
//            changeFragment(
//                ScheduleCheckAddDeleteFragment()
//            )
//        }
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


//   private fun changeFragmentadd(index: Int){
//        when(index){
//            1 -> {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.fragment_schedulecheck, )
//                    .commit()
//            }
//
//            2 -> {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.fl_container, fragment_schedulecheck_add_delete)
//                    .commit()
//            }
//        }
//    }




    }



















