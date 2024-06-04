package com.example.airsofthub.screens


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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.airsofthub.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(
    events: List<String>,
    navigateToEventEntry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name))},
                scrollBehavior = scrollBehavior,

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToEventEntry,
                shape = RoundedCornerShape(10.dp), // Square shape
                modifier = Modifier
                    .size(60.dp)
            ) {
                Text("+")
            }
        },
    ) { innerPadding ->
        AppBody(
            events = events,
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding,
        )
    }
}

@Composable
private fun AppBody(
    events: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (events.isEmpty()) {
            Text(
                text = stringResource(R.string.empty_events),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding),
            )
        } else {
            EventList(
                events = events,
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun EventList(
    events: List<String>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(events) { event ->
            EventItem(event = event, modifier = Modifier)
        }
    }
}
@Composable
private fun EventItem(
    event: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier,
        ) {
            Text(
                text = event,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    AppScreen(events = listOf("Event 1", "Event 2", "Event 3"), navigateToEventEntry = {})
}

@Preview(showBackground = true)
@Composable
fun AppBodyEmptyListPreview() {
    AppBody(events = emptyList(), contentPadding = PaddingValues())
}