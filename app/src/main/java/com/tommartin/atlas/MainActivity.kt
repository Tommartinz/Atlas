package com.tommartin.atlas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tommartin.atlas.ui.AtlasViewModel
import com.tommartin.atlas.ui.screens.DetailScreen
import com.tommartin.atlas.ui.screens.HomeScreen
import com.tommartin.atlas.ui.theme.AtlasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AtlasTheme {
                NavHost(navController, "home_screen") {
                    composable(
                        "home_screen",
                        listOf(navArgument("name") { NavType.StringType })
                    ) {
                        val atlasViewModel = hiltViewModel<AtlasViewModel>()
                        HomeScreen(viewModel = atlasViewModel, navController)
                    }
                    composable(
                        "detail_screen/{name}"
                    ) { backStackEntry ->
                        backStackEntry.arguments?.getString("name")?.let { DetailScreen(it) }
                    }
                }
            }
        }
    }
}