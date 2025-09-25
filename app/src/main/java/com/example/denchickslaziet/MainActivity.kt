package com.example.denchickslaziet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.example.denchickslaziet.ui.fragments.FIrstFragment
import com.example.denchickslaziet.ui.screens.FirstScreen


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ComposeView>(R.id.compose_view).setContent {
            FirstScreen(activity = this)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FIrstFragment())
                .commit()
        }
    }
}
