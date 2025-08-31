package com.example.denchickslaziet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.KeyEventDispatcher.Component
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen()
            Column {
                ShowDialogExample()
            }

        }
    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ShowDialogExample(){
     var showDialog by remember { mutableStateOf(false)}
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {showDialog = true},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )){
                Text("Нажми на меня")

            }
            if (showDialog){
                AlertDialog(
                    onDismissRequest = {showDialog = false},
                    title = {
                        Row(
                            modifier = Modifier,
                           horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,) {
                            Text("У меня к тебе вопрос))", fontSize = 20.sp)
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Закрыть",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { showDialog = false }

                            )
                        }
                    },
                    text = {
                        Text("Сосал?)))") },
                    confirmButton = {
                        Button(onClick = {showDialog = false}) {
                            Text("Да")
                        }
                    }
                )
            }
        }
    }
    @Composable
    fun SecondScreen() {
        Column(
            modifier = Modifier
                .padding(top = 120.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "this second activity",
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(160.dp))
            Button(onClick = { finish() }) {
                Text(
                    "back to firrst activity",
                    fontSize = 30.sp
                )
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun FirstScreenPreview() {
        SecondScreen()
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShoowDialogExamplePreview() {

}
