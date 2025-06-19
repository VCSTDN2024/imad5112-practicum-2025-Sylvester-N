package com.example.androidmusic

object PlaylistObjectClass {

    private const val MAX_ITEMS = 4
    val song = ArrayList<String>()
    val ArtistName = ArrayList<String>()
    val ratings = ArrayList<Int>()
    val comments = ArrayList<String>()

    fun addLogEntry(songs: String, Artistname: String, rating: Int, comment: String){
        if (song.size >= MAX_ITEMS){
            song.removeAt(0)
            ArtistName.removeAt(0)
            ratings.removeAt(0)
            comments.removeAt(0)
        }
        song.add(songs)
        ArtistName.add(Artistname)
        ratings.add(rating)
        comments.add(comment)
    }

    data class SongLog(val songs: String, val Artistname: String, val rating: String, val comment: String)

    fun getAverageRating(): Double {
        if(ratings.isEmpty()) {
            return 0.0
        }
        return ratings.average()
    }

    fun getAllLogs(): List<SongLog> {
        val logs = mutableListOf<SongLog>()
        for (i in song.indices) {
            logs.add(SongLog(song[i], ArtistName[i], ratings[i].toString(), comments[i]))
        }
        return logs
    }


}
