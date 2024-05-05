package com.tommartin.atlas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.tommartin.atlas.data.model.BasicCountry
import com.tommartin.atlas.data.model.DetailedCountry
import com.tommartin.atlas.ui.AtlasViewModel
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(officialName: String, viewModel: AtlasViewModel, navHostController: NavHostController) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(navHostController.currentBackStackEntry) {
        viewModel.getDetailedCountry(officialName)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.value.detailedCountry == null) {
                Text(text = "Nothing here")
            } else {
                Text(text = uiState.value.detailedCountry!![0].region)
            }
        }
    }
}