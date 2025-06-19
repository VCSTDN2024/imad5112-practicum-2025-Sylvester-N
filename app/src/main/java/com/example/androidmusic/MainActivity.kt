package com.example.androidmusic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

         val startBtn = findViewById<Button>(R.id.startBtn)
        val detailsBtn = findViewById<Button>(R.id.detailsBtn)

        detailsBtn.setOnClickListener {
            val intent = Intent(this, InputAdded::class.java)
            startActivity(intent)
        }

        startBtn.setOnClickListener {
            val intent = Intent(this, PlaylistActivity::class.java)
            startActivity(intent)
        }

    }
}