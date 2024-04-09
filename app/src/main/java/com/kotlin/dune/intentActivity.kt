package com.kotlin.dune

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.kotlin.dune.ui.theme.DuneTheme

class intentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
                      com.kotlin.dune.intentscreen()
                }
            }
        }
    }
}

@Composable
fun intentscreen() {
    val context= LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ){
        Text(
            text = "CalcIntent App",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
            )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedButton(onClick =  {
            val takePictureintent= android.content.Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(context as Activity,takePictureintent,1,null)
        },
        colors = ButtonDefaults.buttonColors(Color.Magenta),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
        
        ){
            Text(text = "Camera",
                fontSize = 30.sp)
        }    
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedButton(onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0714704742"))
            if (ContextCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )

            } else {
                context.startActivity(intent)
            }
        },
        colors = ButtonDefaults.buttonColors(Color.Magenta),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "call",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(onClick =  {
            val uri = Uri.parse("smsto:0715316168")

            val intent= Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Hello", "How is todays weather")

            context.startActivity(intent)
        },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Sms",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Stk",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Share",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Email",
                fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(text = "Dial",
                fontSize = 30.sp)

        }


        }
            

    }

@Preview
@Composable
private fun intentprev() {
    intentscreen()
    
}



