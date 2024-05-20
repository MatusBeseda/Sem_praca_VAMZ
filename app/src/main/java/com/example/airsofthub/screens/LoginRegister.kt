package com.example.airsofthub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.airsofthub.R


@Composable
fun LoginRegister() {
    Surface(color = colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(painter = painterResource(id = R.drawable.logo2), contentDescription = "",modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .width(200.dp)
                .height(300.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 150.dp, 16.dp, 0.dp)
                    .border(
                        1.dp,
                        color = colorScheme.primary,
                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
                    )
                    .background(color = colorScheme.surface)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(40.dp)

                ) {
                    Box(modifier = Modifier.height(100.dp), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.pozadie_kruh), contentDescription = "",modifier = Modifier
                            .padding(1.dp)
                            .width(80.dp)
                            .height(80.dp)
                            .background(color = colorScheme.background)
                        )
                        Image(painter = painterResource(id = R.drawable.icona_prihlasovanie), contentDescription = "",modifier = Modifier
                            .padding(0.dp, 0.dp, 5.dp, 0.dp)
                            .width(60.dp)
                            .height(60.dp)
                        )
                    }

                    Button(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.prihlasenie))
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(id = R.string.registrovanie))
                    }
                }
            }
        }
    }
}

    @Preview
    @Composable
    fun LoginRegisterPreview() {
        LoginRegister()
    }
