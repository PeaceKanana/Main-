package com.kotlin.dune

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin.dune.ui.theme.DuneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
  //                  Greeting("Android")
                    login()
                }
            }
        }
    }
}

@Composable
fun login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context= LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
             modifier = Modifier
                 .fillMaxSize()
                 .padding(20.dp)
                 .background(Color.LightGray))
                  {
                  Text(text = "DUNE",
                      color = Color.DarkGray,
                      fontSize = 30.sp,
                      fontFamily = FontFamily.Monospace
                  )
                  OutlinedTextField(
                      value = email ,
                      onValueChange ={email=it},
                      label = { Text(text = "Email Address",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif
                      )
                      },

                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(vertical = 0.5.dp),
                      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                      keyboardActions = KeyboardActions()
                  )
Spacer(modifier = Modifier.height(20.dp))


                      OutlinedTextField(
                          value = password ,
                          onValueChange ={password=it},
                          label = { Text(text = "Password",
                              fontSize = 20.sp,
                              fontFamily = FontFamily.SansSerif)},
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(vertical = 0.5.dp),
                          keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                          keyboardActions = KeyboardActions()
                      )
                      Spacer(modifier = Modifier.height(20.dp))

                      Button(onClick = { /*TODO*/ },
                          ){
                         Text(text = "Submit",
                             fontSize = 22.sp)
                      }
                      Spacer(modifier = Modifier.height(20.dp))
                      Button(onClick = { val intent=Intent(context,RegisterActivity:: class.java)
                                       context.startActivity(intent)},
                      ){
                          Text(text = "To Register",
                              fontSize = 22.sp)




    }

}}

@Preview
@Composable
private fun loginprev() {
    login()

}