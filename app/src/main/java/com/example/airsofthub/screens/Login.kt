package com.example.airsofthub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.airsofthub.R
import com.example.airsofthub.data.UserDao
import com.example.airsofthub.viewModels.LoginViewModel


@Composable
fun Login(viewModel: LoginViewModel,onBack: () -> Unit, onLoginSuccess: () -> Unit) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 350.dp, 16.dp, 0.dp)
                    .border(
                        1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
                    )
                    .background(color = MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(40.dp)

                ) {
                    Box(modifier = Modifier.height(100.dp), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.pozadie_kruh),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(1.dp)
                                .width(40.dp)
                                .height(40.dp)
                                .background(color = MaterialTheme.colorScheme.background)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(5.dp, 0.dp, 5.dp, 0.dp)
                                .width(30.dp)
                                .height(30.dp)
                        )


                    }
                    TextField(
                        value = viewModel.username.value,
                        onValueChange = { newValue -> viewModel.onUsernameChange(newValue)},
                        label = {
                            Text(
                                stringResource(R.string.meno_register)
                            )
                        },
                        modifier = Modifier
                            .width(289.dp)
                            .height(49.dp)
                    )
                    TextField(
                        value = viewModel.password.value,
                        onValueChange = { newValue -> viewModel.onPasswordChange(newValue) },
                        label = {
                            Text(
                                stringResource(R.string.heslo_register_value)
                            )
                        },
                        modifier = Modifier
                            .width(289.dp)
                            .height(49.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(40.dp, alignment = Alignment.CenterHorizontally),
                )
                {

                    Button(onClick = {  onBack() }) {
                        Text(text = stringResource(R.string.spat_register))
                    }
                    Button(onClick = { val success = viewModel.onLogin(username.value, password.value)
                    if (success) {
                        onLoginSuccess()

                    }
                }) {
                        Text(text = stringResource(R.string.login_prihlasit))
                    }
                }
            }
        }
    }
}

