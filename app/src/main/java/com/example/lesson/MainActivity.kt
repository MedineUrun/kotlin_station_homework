package com.example.lesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

     var firstButton:Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        firstButton = findViewById(R.id.fsButton)

        firstButton!!.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java )
            startActivity(intent)
        }



    }
}