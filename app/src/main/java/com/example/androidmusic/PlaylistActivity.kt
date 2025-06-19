package com.example.androidmusic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlaylistActivity : AppCompatActivity() {

    private lateinit var inputSongEt: EditText
    private lateinit var inputArtistNameEt: EditText
    private lateinit var inputRatingEt: EditText
    private lateinit var inputCommentEt: EditText
    private lateinit var AddToPlyBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist)

        inputSongEt = findViewById(R.id.inputSongEt)
        inputArtistNameEt = findViewById(R.id.inputArtistNameEt)
        inputRatingEt = findViewById(R.id.inputRatingEt)
        inputCommentEt = findViewById(R.id.inputCommentEt)
        AddToPlyBtn = findViewById(R.id.AddToPlyBtn)

        AddToPlyBtn.setOnClickListener{
            val songs = inputSongEt.text.toString()
            val artistName = inputArtistNameEt.text.toString()
            val rating = inputRatingEt.text.toString()
            val comment = inputCommentEt.text.toString()

            if (songs.isNotEmpty() && artistName.isNotEmpty() && rating.isNotEmpty() && comment.isNotEmpty()){
                try {
                    val rating = rating.toInt()

                    PlaylistObjectClass.addLogEntry(songs, artistName, rating, comment)

                    Toast.makeText(this, "Log added successfully!", Toast.LENGTH_LONG).show()
                    finish()
                } catch (e: NumberFormatException){
                    Toast.makeText(this, "Please Enter valid number for rating", Toast.LENGTH_SHORT).show()
                }
            }else {
                Toast.makeText(this, "Please fill in all feilds", Toast.LENGTH_SHORT).show()
            }
        }


    }
}