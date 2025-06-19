package com.example.androidmusic

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputAdded : AppCompatActivity() {


    private lateinit var reviewBtn: Button
    private lateinit var homeBtn: Button
    private lateinit var exitBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_added)


        reviewBtn = findViewById(R.id.reviewBtn)
        exitBtn = findViewById(R.id.exitBtn)
        homeBtn = findViewById(R.id.homeBtn)

        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        reviewBtn.setOnClickListener{
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener{
            finishAffinity()
        }


    }
}