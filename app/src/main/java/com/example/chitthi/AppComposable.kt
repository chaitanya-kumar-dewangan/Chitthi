package com.example.chitthi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatter.feature.me.signinp.SignIn
import com.example.chitthi.feature.home.HomeSc
import com.example.chitthi.feature.me.Signupp.SignUp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun App() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        val currentUser = FirebaseAuth.getInstance().currentUser
        val start = if (currentUser != null) "home" else "login"
        NavHost(navController = navController, startDestination = start) {

            composable("login") {
                SignIn(navController)
            }
            composable("signup") {
                SignUp(navController)
            }
            composable("home") {
                HomeSc(navController)
            }
        }
    }
}