package com.kmj.timetuning_hackathon

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.kmj.timetuning_hackathon.databinding.PlanInfoDialogBinding

class PlanInfoDialog(
    contentLayoutId: Int
) : DialogFragment(contentLayoutId) {
    lateinit var binding:PlanInfoDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= PlanInfoDialogBinding.inflate(inflater,container,false)

        // dialog 클릭 시 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 취소 버튼 클릭
        binding.dialogCancelBtn.setOnClickListener {
            dismiss()
        }

        // x 버튼 클릭
        binding.dialogCancelIv.setOnClickListener {
            dismiss()
        }
        // 확정 버튼 클릭
        binding.dialogConfirmBtn.setOnClickListener {

        }

        return binding.root
    }
}