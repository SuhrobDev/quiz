package com.example.quiz_full

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        val actionBar = supportActionBar
        actionBar!!.hide()
        val startbutton : Button = findViewById<View>(R.id.start) as Button
        val aboutbutton : Button = findViewById<View>(R.id.about) as Button
        val quitbutton : Button = findViewById<View>(R.id.quit) as Button
        //val nametext = findViewById<View>(R.id.editName) as EditText
        startbutton.setOnClickListener {
//            val name = nametext.text.toString()
//            if (name.trim().length in 4..8){
//                val intent = Intent(applicationContext , QuestionAct::class.java)
//                intent.putExtra("myname" , name)
//                startActivity(intent)
//            }else{
//               // Toast.makeText(this , "please enter valid name" , Toast.LENGTH_SHORT).show()
//                Toast.makeText(
//                    applicationContext ,
//                    "please enter valid name" ,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
            val intent = Intent(applicationContext , QuestionAct::class.java)
            startActivity(intent)
            finish()
        }
        aboutbutton.setOnClickListener {
            val intent = Intent(applicationContext , DevActivity::class.java)
            startActivity(intent)
            finish()
        }
        quitbutton.setOnClickListener {
            finish()
            onDestroy()
            exitProcess(0)
        }
    }
}