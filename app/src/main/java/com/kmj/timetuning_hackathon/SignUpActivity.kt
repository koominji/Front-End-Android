package com.kmj.timetuning_hackathon

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kmj.timetuning_hackathon.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity(){

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    //회원가입시 입력값 가져오기
    private fun getUser() : User{
        val id: String = binding.signUpIdEt.text.toString()
        val name : String = binding.signUpNameEt.text.toString()
        val password : String = binding.signUpPwdEt.text.toString()


        return User(id,name,password)
    }

    //회원가입 진행 함수
    private  fun signUp(){
        //입력되지 않았을때 회원가입이 되지 않도록
        if (binding.signUpIdEt.text.toString().isEmpty()){
            Toast.makeText(this,"아이디 형식이 잘못되었습니다.",Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.signUpPwdEt.text.toString()!= binding.signUpPwdCheckEt.text.toString()){
            Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show()
            return
        }

        //데이터베이스 저장
        //val userDB =
    }






}