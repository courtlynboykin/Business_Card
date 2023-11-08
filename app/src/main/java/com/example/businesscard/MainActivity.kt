package com.example.businesscard

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun BusinessCardApp(){
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

@Composable
private fun PersonalInfo(
    image: Painter,
    name: String,
    title: String,
    company: String,
    team: String,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                vertical = 100.dp,
                horizontal = 150.dp
            )
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(150.dp)
        )
        Text(
            text = name,
            modifier = modifier
        )
        Text(
            text = title,
            modifier = modifier
        )
        Text(
            text = company,
            modifier = modifier
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
    Column (
        verticalArrangement = Arrangement.Bottom
    ){
        Row {
            Icon(
                Icons.Rounded.Person,
                contentDescription = null
            )
            Text(
                text = linkedin,
                modifier = modifier
            )
        }
        Row {
            Icon(
                Icons.Rounded.CheckCircle,
                contentDescription = null
            )
            Text(
                text = github,
                modifier = modifier
            )
        }
        Row {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null
            )
            Text(
                text = email,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}