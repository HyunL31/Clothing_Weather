package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1.ui.theme.Project1Theme

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPage()
        }
    }
}

@Composable
fun LoginPage()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(R.drawable.icon_weather_background),
            contentDescription = "This is main icon",
            modifier = Modifier
                .size(128.dp)
                .align(Alignment.CenterHorizontally)
        )

        var text by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            leadingIcon = { Icon(Icons.Rounded.Person) },
            value = text,
            KeyboardOptions = KeyboardOptions(keyboardType = keyboardType.Text),
            onValueChange{ text = it },
            label { Text(text = "User Name") },
            placeholder { Text(text = "Enter your username") },
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        OutlinedTextField(
            value = text,
            KeyboardOptions = KeyboardOptions(keyboardType = keyboardType.Text),
            onValueChange{ text = it },
            label { Text(text = "Password") },
            placeholder { Text(text = "Enter your password") },
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview()
{
    Project1Theme {
        LoginPage()
    }
}