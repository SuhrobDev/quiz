package com.example.quiz_full

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class DevActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
//        val actionBar = supportActionBar
//        actionBar!!.hide()
        setContentView(R.layout.activity_developer1)
        findViewById<AppCompatButton>(R.id.backbtn).setOnClickListener {
            val intent = Intent(applicationContext , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
