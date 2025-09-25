package com.example.denchickslaziet.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.denchickslaziet.MainActivity
import com.example.denchickslaziet.SecondActivity

@Composable
fun FirstScreen(activity: MainActivity? = null) {
    Column(
        modifier = Modifier
            .padding(top = 100.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("this first activity", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(160.dp))

        Button(
            onClick = {

                activity?.let {
                    val intent = Intent(it, SecondActivity::class.java)
                    it.startActivity(intent)
                }
            }
        ) {
            Text("next to activity", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen()
}
