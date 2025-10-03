package com.example.denchickslaziet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.denchickslaziet.ui.screens.SecondScreen
import com.example.denchickslaziet.ui.screens.ShowDialogScreen

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen(onBackClick = { finish() })
            ShowDialogScreen()
        }
    }
}
