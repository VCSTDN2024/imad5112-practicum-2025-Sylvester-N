package com.example.androidmusic

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Details : AppCompatActivity() {

    private lateinit var tvAllLogsList: TextView
    private lateinit var avgBtn: Button
    private lateinit var highRatingTv: TextView
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        tvAllLogsList = findViewById(R.id.tvAllLogsList)
        avgBtn = findViewById(R.id.avgBtn)
        highRatingTv = findViewById(R.id.highRatingTv)
        backBtn = findViewById(R.id.backBtn)


        LoadAndDisplayReviewData()

        avgBtn.setOnClickListener{
            val averageRating = PlaylistObjectClass.getAverageRating()
            highRatingTv.text = String.format(Locale.getDefault(),"%.1f Rating", averageRating)
        }

        backBtn.setOnClickListener{
            finish()
        }


    }

    private fun LoadAndDisplayReviewData() {
        val allLogs = PlaylistObjectClass.getAllLogs()
        if (allLogs.isNotEmpty()){
            val logsText = StringBuilder()
            allLogs.forEachIndexed { index, log ->
                logsText.append("playlist ${index + 1}:\n")
                logsText.append("Song:    ${log.songs}\n")
                logsText.append("Rating:   ${log.Artistname}\n")
                logsText.append("Rating:   ${log.rating}\n")
                logsText.append("Comments:  ${log.comment}\n")
            }
            tvAllLogsList.text = logsText.toString()
        }else {
            tvAllLogsList.text = "No songs added to the playlist"
        }
    }


}
