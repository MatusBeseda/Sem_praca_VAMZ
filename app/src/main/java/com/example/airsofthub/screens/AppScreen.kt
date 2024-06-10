@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.airsofthub.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.airsofthub.R
import com.example.airsofthub.viewModels.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(

    events: List<Event>,
    navigateToEventEntry: () -> Unit,
    navigateToEventDetails: (Event) -> Unit
) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToEventEntry,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(60.dp)
            ) {
                Text(stringResource(R.string.symbol))
            }
        }
    ) { innerPadding ->
        AppBody(
            events = events,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navigateToEventDetails = navigateToEventDetails
        )
    }
}

@Composable
fun AppBody(
    events: List<Event>,
    modifier: Modifier = Modifier,
    navigateToEventDetails: (Event) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (events.isEmpty()) {
            Text(
                text = stringResource(R.string.empty_events),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding)
            )
        } else {
            EventList(events = events, navigateToEventDetails = navigateToEventDetails)
        }
    }
}

@Composable
fun EventList(
    events: List<Event>,
    navigateToEventDetails: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(events) { event ->
            EventItem(event = event, onClick = { navigateToEventDetails(event) })
        }
    }
}

@Composable
fun EventItem(
    event: Event,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.name, style = MaterialTheme.typography.titleLarge)
            Text(text = event.location, style = MaterialTheme.typography.bodyLarge)
            Text(text = event.dateTime, style = MaterialTheme.typography.bodyLarge)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    AppScreen(
        events = listOf(
            Event("Event 1", "Location 1", "2024-05-01 10:00 AM", "Ahoj"),
            Event("Event 2", "Location 2", "2024-05-02 11:00 AM", "Ahoj"),
            Event("Event 3", "Location 3", "2024-05-03 12:00 PM", "Ahoj")
        ),
        navigateToEventEntry = {},
        navigateToEventDetails = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AppBodyEmptyListPreview() {
    AppBody(events = emptyList(), navigateToEventDetails = {}, contentPadding = PaddingValues())
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppEventDetailsScreen(event: Event) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(event.name) }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = event.name, style = MaterialTheme.typography.titleLarge)
                Text(text = event.location, style = MaterialTheme.typography.bodyLarge)
                Text(text = event.dateTime, style = MaterialTheme.typography.bodyLarge)
            }
        }
    )
}


data class Event(
    val name: String,
    val location: String,
    val dateTime: String,
    val description: String
)