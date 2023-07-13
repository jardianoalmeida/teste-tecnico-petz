package com.jardiano.petz.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jardiano.petz.ui.PetzApp
import com.jardiano.petz.ui.theme.PetzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PetzTheme {
                PetzApp()
            }
        }
    }
}