package com.example.biggernumbergame

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getRandomNumbers()
        button1.setOnClickListener()
        {
            checknumbers(true)
            getRandomNumbers()
        }
        button2.setOnClickListener()
        {
            checknumbers(false)
            getRandomNumbers()
        }

    }
    private fun checknumbers(isLeftSelected:Boolean){
        val num1=button1.text.toString().toInt()
        val num2=button2.text.toString().toInt()
        val answer=if(isLeftSelected) num1>num2 else num1<num2
        if(answer){
            backgroundview.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show()
        }else{
            backgroundview.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getRandomNumbers() {
        val s= Random()
        val left=s.nextInt(10)
        var right=left
        while(right==left)
        {
            right=s.nextInt(10)
        }


        button1.text= left.toString()
        button2.text= right.toString()

    }
}