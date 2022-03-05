package com.example.quiz_full

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ResultAct : AppCompatActivity() {
    var tv : TextView? = null
    var tv2 : TextView? = null
    var tv3 : TextView? = null
    var btnRestart : Button? = null
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
//        val actionBar = supportActionBar
//        actionBar!!.hide()
        tv = findViewById<View>(R.id.Correct) as TextView
        tv2 = findViewById<View>(R.id.Wrong) as TextView
        tv3 = findViewById<View>(R.id.Score) as TextView
        btnRestart = findViewById<View>(R.id.btnRestart) as Button
        val sb = StringBuffer()
        sb.append(
            """
                Correct answers: ${QuestionAct.correct}
                
                """.trimIndent()
        )
        val sb2 = StringBuffer()
        sb2.append(
            """
                Wrong Answers: ${QuestionAct.wrong}
                
                """.trimIndent()
        )
        val sb3 = StringBuffer()
        sb3.append(
            """
                Final Score: ${QuestionAct.correct}
                
                """.trimIndent()
        )
        tv!!.text = sb
        tv2!!.text = sb2
        tv3!!.text = sb3
        QuestionAct.correct = 0
        QuestionAct.wrong = 0
        btnRestart!!.setOnClickListener {
            val intent = Intent(applicationContext , QuestionAct::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.btnQuit).setOnClickListener {
            finish()
            onDestroy()
            exitProcess(0)
        }
    }
}