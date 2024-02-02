package com.example.shop.presentation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.const_vals.FIRST_RUN
import com.example.const_vals.NAME

@Composable
fun MyApp(
    modifier: Modifier,
    sharedPrefs: SharedPreferences
) {
    val navController = rememberNavController()

    var startDestination by remember {
        mutableStateOf("")
    }
    val name = sharedPrefs.getString(NAME, "")

    startDestination = if (name.isNullOrEmpty()) {
        "onBoarding"
    } else {
        "mainScreen"
    }

    var startDestination2 by remember {
        mutableStateOf("")
    }
    val firstRun = sharedPrefs.getString(FIRST_RUN, "")

    startDestination2 = if (firstRun.isNullOrEmpty()) {
        "start"
    } else {
        "catalogue"
    }


    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(route = "onBoarding") {
            Onboarding(
                modifier = modifier,
                onClick = {
                    val firstRun2 = sharedPrefs.getString(FIRST_RUN, "")

                    if (firstRun2.isNullOrEmpty()) {
                        startDestination2 = "start"
                        val editor = sharedPrefs.edit()
                        editor.putString(FIRST_RUN, "firstRun")
                        editor.apply()
                    } else {
                        startDestination2 = "catalogue"
                    }
                    navController.navigate("mainScreen") {
                        popUpTo("onBoarding") {
                            inclusive = true
                        }
                    }
                },
                sharedPreferences = sharedPrefs
            )
        }
        composable(route = "mainScreen") {
            MainScreen(
                sharedPreferences = sharedPrefs,
                modifier = modifier,
                onClick = {
                    navController.navigate("onBoarding") {
                        popUpTo("mainScreen") {
                            inclusive = true
                        }
                    }
                },
                startDestination = startDestination2
            )
        }
    }
}