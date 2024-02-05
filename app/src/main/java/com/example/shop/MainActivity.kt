package com.example.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.const_vals.PREFS
import com.example.shop.presentation.MyApp
import com.example.shop.ui.theme.ShopTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val sharedPrefs = getSharedPreferences(PREFS, MODE_PRIVATE)

        setContent {
//            Box(
//                Modifier
//                    .background(Color(0xFFD62F89))
//                    .statusBarsPadding()
//            ) {
//                Box(
//                    Modifier
//                        .background(Color(0xFFD62F89))
//                        .navigationBarsPadding()
//                ) {
            ShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding),
                        sharedPrefs = sharedPrefs
                    )
                }
            }
        }
    }
}
    