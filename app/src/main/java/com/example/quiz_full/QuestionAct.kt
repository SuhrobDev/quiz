package com.example.quiz_full

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuestionAct : AppCompatActivity() {
    private var questionView : TextView? = null
    private var submitbutton : Button? = null
    private var answersList : RadioGroup? = null
    private var btnA : RadioButton? = null
    private var btnB : RadioButton? = null
    private var btnC : RadioButton? = null
    private var btnD : RadioButton? = null
    private var questions = arrayOf(
        "Which method can be defined only once in a program?" ,
        "Which of these is not a bitwise operator?" ,
        "Which keyword is used by method to refer to the object that invoked it?" ,
        "Which of these keywords is used to define interfaces in Java?" ,
        "Which of these access specifiers can be used for an interface?" ,
        "Which of the following is correct way of importing an entire package ‘pkg’?" ,
        "What is the return type of Constructors?" ,
        "Which of the following package stores all the standard java classes?" ,
        "Which of these method of class String is used to compare two String objects for their equality?" ,
        "An expression involving byte, int, & literal numbers is promoted to which of these?"
    )
    private var answers = arrayOf(
        "main method" ,
        "<=" ,
        "this" ,
        "interface" ,
        "public" ,
        "import pkg.*" ,
        "None of the mentioned" ,
        "java" ,
        "equals()" ,
        "int"
    )
    private var opt = arrayOf(
        "finalize method" , "main method" , "static method" , "private method" ,
        "&" , "&=" , "|=" , "<=" ,
        "import" , "this" , "catch" , "abstract" ,
        "Interface" , "interface" , "intf" , "Intf" ,
        "public" , "protected" , "private" , "All of the mentioned" ,
        "Import pkg." , "import pkg.*" , "Import pkg.*" , "import pkg." ,
        "int" , "float" , "void" , "None of the mentioned" ,
        "lang" , "java" , "util" , "java.packages" ,
        "equals()" , "Equals()" , "isequal()" , "Isequal()" ,
        "int" , "long" , "byte" , "float"
    )
    private var flag = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
//        val actionBar = supportActionBar
//        actionBar!!.hide()
//        val textView = findViewById<TextView>(R.id.DispName)
//        val intent : Intent = intent
//        val name = intent.getStringExtra("myname")
//        if (name!!.trim { it <= ' ' } == "") textView.text = "Hello User" else textView.text =
//           "Hello $name"
        submitbutton = findViewById(R.id.button3)
        questionView = findViewById(R.id.questionView)
        answersList = findViewById(R.id.answers)
        btnA = findViewById(R.id.ButtonA)
        btnB = findViewById(R.id.ButtonB)
        btnC = findViewById(R.id.ButtonC)
        btnD = findViewById(R.id.ButtonD)
        questionView!!.text = questions[flag]
        btnA!!.text = opt[0]
        btnB!!.text = opt[1]
        btnC!!.text = opt[2]
        btnD!!.text = opt[3]
        submitbutton!!.setOnClickListener(View.OnClickListener {
            //int color = mBackgroundColor.getColor();
            //mLayout.setBackgroundColor(color);
            if (answersList!!.checkedRadioButtonId == -1) {
                Toast.makeText(
                    applicationContext ,
                    "Please select one choice" ,
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            val uans = findViewById<RadioButton>(answersList!!.checkedRadioButtonId)
            val ansText = uans.text.toString()
            //                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
            if (ansText == answers[flag]) {
                correct++
                //Toast.makeText(applicationContext , "Correct" , Toast.LENGTH_SHORT).show()
            } else {
                wrong++
                //Toast.makeText(applicationContext , "Wrong" , Toast.LENGTH_SHORT).show()
            }
            flag++
            if (flag < questions.size) {
                questionView!!.text = questions[flag]
                btnA!!.text = opt[flag * 4]
                btnB!!.text = opt[flag * 4 + 1]
                btnC!!.text = opt[flag * 4 + 2]
                btnD!!.text = opt[flag * 4 + 3]
            } else {
                marks = correct
                val intent = Intent(applicationContext , ResultAct::class.java)
                startActivity(intent)
                finish()
            }
            answersList!!.clearCheck()
        })
    }

    companion object {
        var marks = 0
        var correct = 0
        var wrong = 0
    }
}