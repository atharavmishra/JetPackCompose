package android.myapplication.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.myapplication.jetpackcompose.ui.theme.JetpackComposeTheme
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.security.AllPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) { var text by remember { mutableStateOf("Type here") }
        TextField(value = text, onValueChange = {newText -> text = newText},
        label = {Text (text = "Title")}, singleLine = true,
        leadingIcon = { IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email Icon"
            )
        }},
        trailingIcon = { IconButton(onClick = { Log.d("Search", "This is search")}) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Email Icon"
            )
        }},
        keyboardOptions = KeyboardOptions(keyboardType=KeyboardType.Email,
            imeAction = ImeAction.Search), keyboardActions = KeyboardActions (onSearch = {Log.d("Log", "search clicked")})
        )
    }

}
@Composable
fun Customtext(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue), contentAlignment = Alignment.TopCenter, ){
        Box(modifier = Modifier.background(Color.Red)){
            Text(text = "Atharv")
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {

        Greeting()
            }


    }
