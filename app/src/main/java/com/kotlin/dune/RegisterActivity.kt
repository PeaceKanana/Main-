package com.kotlin.dune

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin.dune.ui.theme.ui.theme.DuneTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    reg()

                }
            }
        }
    }
}

@Composable
fun reg() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    var hint by remember { mutableStateOf("") }
    val context= LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.LightGray)
    ){
        Text(text = "Register here",
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif
        )
        OutlinedTextField(
            value = name,
            onValueChange = {name=it},
            label = { Text(text = "Enter Your Name",
                           fontSize = 20.sp,
                           fontFamily = FontFamily.SansSerif
            )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.5.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text(text = "Enter Your Email",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.5.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = {confirmpassword=it},
            label = { Text(text = "Confirm Your Password",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.5.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = hint,
            onValueChange = {hint=it},
            label = { Text(text = "Give hint for your password",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.5.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ },
             modifier = Modifier


        ){
            Text(text = "Register",
                fontSize = 22.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {val intent=Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        },
        ){
            Text(text = "Back to login",
                fontSize = 22.sp)


    }

}}
    @Preview
@Composable
private fun regprev() {
    reg()

}
