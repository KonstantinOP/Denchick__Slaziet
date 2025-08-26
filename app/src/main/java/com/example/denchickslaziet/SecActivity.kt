package com.example.denchickslaziet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.KeyEventDispatcher.Component
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen()
        }
    }

   @Composable
   fun SecondScreen() {
       Column(modifier = Modifier
           .padding(top = 120.dp)
           .fillMaxWidth(),
           horizontalAlignment = Alignment.CenterHorizontally) {
           Text("this second activity", fontSize = 30.sp)
           Spacer(modifier = Modifier. height(160.dp))
           Button(onClick = {finish()}) { Text("back to firrst activity", fontSize = 30.sp) }
       }




    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun FirstScreenPreview() {
        SecondScreen()
    }


}