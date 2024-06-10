package com.example.airsofthub.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey val name: String,
    val location: String,
    val dateTime: String,
    val description: String
)
