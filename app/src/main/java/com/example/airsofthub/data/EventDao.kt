package com.example.airsofthub.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {
    @Query("SELECT * FROM events")
    fun getAllEvents(): List<Event>

    @Query("SELECT * FROM events WHERE name = :name")
    fun getEventById(name: String): Event?

    @Insert
    fun insertEvent(event: com.example.airsofthub.screens.Event)


}