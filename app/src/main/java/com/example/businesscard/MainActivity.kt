package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color(0xFFd2e8d4))
    ) {
        PersonalInfo(
            image = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            company = stringResource(R.string.company),
            team = stringResource(R.string.team)
        )
        ContactInfo(
            linkedin = stringResource(R.string.linkedin),
            github = stringResource(R.string.github),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
private fun PersonalInfo(
    image: Painter,
    name: String,
    title: String,
    company: String,
    team: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                start = 50.dp,
                top = 150.dp,
                end = 50.dp
            )
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .padding(horizontal = 75.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 15.dp)
        )
        Text(
            text = title,
            color = Color(0xFF073b3a),
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = company,
            modifier = modifier.padding(vertical = 5.dp)
        )
        Text(
            text = team,
            modifier = modifier
        )
    }
}

@Composable
private fun ContactInfo(
    linkedin: String,
    github: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 50.dp,
                top = 40.dp
            )
    ) {
        Row(
            modifier = modifier
                .padding(vertical = 4.dp)
        ) {
            Icon(
                Icons.Rounded.Person,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = linkedin,
                modifier = modifier

            )
        }
        Row(
            modifier = modifier
                .padding(vertical = 4.dp)
        ) {
            Icon(
                Icons.Rounded.Add,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = github,
                modifier = modifier
            )
        }
        Row(
            modifier = modifier
                .padding(vertical = 4.dp)
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = email,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}