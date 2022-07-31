package com.kmj.timetuning_hackathon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

import com.kmj.timetuning_hackathon.databinding.FragmentSchedulecheckBinding
import kotlinx.android.synthetic.main.fragment_schedulecheck.*

class ScheduleCheckFragment : Fragment() {

    private lateinit var btn_update_plan_button: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedulecheck, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_update_plan_button = view.findViewById(R.id.btn_update_plan_button)

        btn_update_plan_button.setOnClickListener {
            val intent = Intent(getActivity(), ScheduleCheckAddDeleteActivity::class.java)
            startActivity(intent)
        }
    }
}