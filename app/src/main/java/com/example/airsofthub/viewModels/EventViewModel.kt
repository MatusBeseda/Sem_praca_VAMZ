package com.example.airsofthub.viewModels

import androidx.lifecycle.ViewModel
import com.example.airsofthub.data.Event
import com.example.airsofthub.data.EventDao

class EventViewModel(private val eventDao: EventDao) : ViewModel() {
    fun addEvent(event: com.example.airsofthub.screens.Event) {
        eventDao.insertEvent(event)
    }

    fun getAllEvents(): List<Event> {
        return eventDao.getAllEvents()
    }
}