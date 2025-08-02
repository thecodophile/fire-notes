package com.somnathdey.firenotes.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.somnathdey.auth.ui.AuthScreen

object AuthNavGraph : BaseNavGraph{

//    sealed interface Destination{
//        @Serializable
//        data object Root : Destination
//
//        @Serializable
//        data object Auth: Destination
//    }
//
//    override fun build(
//        modifier: Modifier,
//        navController: NavHostController,
//        navGraphBuilder: NavGraphBuilder
//    ) {
//        navGraphBuilder.navigation<Destination.Root>(
//            startDestination = Destination.Auth
//        ){
//            composable< Destination.Auth>{
//                AuthScreen(modifier = modifier)
//            }
//        }
//    }

    sealed class Destination(val route: String) {
        object Root : Destination("auth_root")
        object Auth : Destination("auth_screen")
    }

    override fun build(
        modifier: Modifier,
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = Destination.Auth.route,
            route = Destination.Root.route
        ) {
            composable(Destination.Auth.route) {
                AuthScreen(modifier = modifier)
            }
        }
    }

}