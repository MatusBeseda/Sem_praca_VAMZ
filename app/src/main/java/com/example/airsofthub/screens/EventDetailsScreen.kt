package com.example.airsofthub.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.airsofthub.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailsScreen(event: Event) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(event.name) }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.MiestoDetails, event.location), style = MaterialTheme.typography.bodyLarge)
                Text(text = stringResource(R.string.dateDetails, event.dateTime), style = MaterialTheme.typography.bodyLarge)
                Text(text = stringResource(R.string.popis,event.description), style = MaterialTheme.typography.bodyLarge)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EventDetailsScreenPreview() {
    val event = Event(
        name = stringResource(R.string.test_event),
        location = stringResource(R.string.test_miesto),
        dateTime = stringResource(R.string.dateTime_Test),
        description = stringResource(R.string.test_popis)
    )
    EventDetailsScreen(event = event)
}