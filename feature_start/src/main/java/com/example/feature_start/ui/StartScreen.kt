package com.example.feature_start.ui

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.const_vals.FIRST_RUN
import com.example.feature_start.R

@Composable
fun StartScreen(
    sharedPreferences: SharedPreferences
) {
    val editor = sharedPreferences.edit()
    editor.putString(FIRST_RUN, "firstRun")
    editor.apply()
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Главная",
            modifier = Modifier.align(Alignment.TopCenter),
            fontFamily = FontFamily(
                Font(R.font.medium)
            ),
            fontSize = 16.sp
        )
    }
}