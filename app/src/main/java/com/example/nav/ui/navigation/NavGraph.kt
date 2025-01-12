package com.example.nav.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.nav.ui.screens.FriendListScreen
import com.example.nav.ui.screens.ProfileScreen

// Define the MyApp composable, including the `NavController` and `NavHost`
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Profile(name = "John Smith")) {
        composable<Profile> { backStackEntry ->
            val profile: Profile = backStackEntry.toRoute()
            ProfileScreen(
                profile = profile,
                onNavigateToFriendList = {
                    navController.navigate(route = FriendList)
                }
            )
        }
        composable<FriendList> {
            FriendListScreen(
                onNavigateToProfile = {
                    navController.navigate(
                        route = Profile(name = "Aisha Devi")
                    )
                }
            )
        }
    }
}