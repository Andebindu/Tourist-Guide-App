package com.touristguide.routing

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.touristguide.ui.detail.DetailScreen
import com.touristguide.ui.login.LoginScreen
import com.touristguide.ui.main.MainScreen
import com.touristguide.ui.model.PlaceModel
import com.touristguide.ui.register.RegisterScreen
import com.touristguide.ui.splash.SplashScreen
import kotlin.math.log

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Detail.route+ "/{name}"+"/{image}"+"/{detail}") {
            val name = it.arguments?.getString("name")
            val image = it.arguments?.getString("image").toString().toInt()
            val detail = it.arguments?.getString("detail")
            if (name != null) {
                if (image != null) {
                    if (detail != null) {
                        DetailScreen(navController = navController, name = name, image = image,detail = detail)
                    }
                }
            }
        }
    }

}