package com.example.denchickslaziet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.denchickslaziet.ui.screens.FirstScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                FirstScreen(
                    onNavigateToSecond = {
                        startActivity(Intent(this, SecondActivity::class.java))
                    }
                )
            }
        }
    }
}
