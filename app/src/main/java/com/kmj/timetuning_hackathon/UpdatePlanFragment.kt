package com.kmj.timetuning_hackathon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class UpdatePlanFragment : Fragment() {

    private lateinit var plan_plus: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_updateplan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plan_plus = view.findViewById(R.id.plan_plus)

        plan_plus.setOnClickListener {
            val intent = Intent(getActivity(), CalendarActivity::class.java)
            startActivity(intent)
        }
    }








}