package com.example.airsofthub.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.airsofthub.R
import com.example.airsofthub.viewModels.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventEntryScreen(viewModel: EventViewModel, onEventEntry: (Event) -> Unit) {
    val name = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val dateTime = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.nova_udalost)) }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(stringResource(R.string.nazov)) }
                )
                TextField(
                    value = location.value,
                    onValueChange = { location.value = it },
                    label = { Text(stringResource(R.string.miesto)) }
                )
                TextField(
                    value = dateTime.value,
                    onValueChange = { dateTime.value = it },
                    label = { Text(stringResource(R.string.datumACas)) }
                )
                TextField(
                    value = description.value,
                    onValueChange = { description.value = it },
                    label = { Text(stringResource(R.string.popisEventEntry)) }
                )
                Button(
                    onClick = {
                        val newEvent = Event(name.value, location.value, dateTime.value, description.value)
                        viewModel.addEvent(newEvent)
                        onEventEntry(newEvent)
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(stringResource(R.string.pridatUdalost))
                }
            }
        }
    )
}



