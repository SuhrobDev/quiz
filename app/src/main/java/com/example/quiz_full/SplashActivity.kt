package com.example.quiz_full

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_full.utils.SharedPreferencesHelper

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    val shared by lazy {
        SharedPreferencesHelper(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar : ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.splash_activity)
        //startTimer()
    object :CountDownTimer(3000,1000){
        override fun onTick(millisUtilFinished : Long) {}

        override fun onFinish() {
            shared.loadLocale(this@SplashActivity)
            finish()
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }.start()
    }

//    private fun startTimer() {
//
//        object : CountDownTimer(3000, 1000) {
//            override fun onFinish() {
//                shared.loadLocale(this@SplashActivity)
//                finish()
//                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//            }
//
//            override fun onTick(millisUntilFinished: Long) {
//
//            }
//
//        }.start()
//    }
}