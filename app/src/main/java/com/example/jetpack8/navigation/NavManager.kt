package com.example.jetpack8.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack8.dataStore.StoreBoarding
import com.example.jetpack8.onboardviews.MainOnBoarding
import com.example.jetpack8.views.HomeView
import com.example.jetpack8.views.SplashScreen

@Composable
fun NavManager(){
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if(store.value)"Home" else "Splash") {
        composable("onBoarding"){
            MainOnBoarding(navc = navController, store = dataStore)
        }
        composable("Home"){
            HomeView(navC = navController)
        }
        composable("Splash"){
            SplashScreen(navController,store.value)
        }
    }
}