package com.tommartin.atlas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tommartin.atlas.ui.AtlasViewModel
import com.tommartin.atlas.ui.components.CountryCard
import com.tommartin.atlas.ui.components.SearchBarComponent

@Composable
fun HomeScreen(viewModel: AtlasViewModel = viewModel()) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(uiState) {
        viewModel.getAllCountries()
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .semantics { isTraversalGroup = true },
            contentAlignment = Alignment.TopCenter
        ) {
            SearchBarComponent()
            LazyVerticalGrid(
                contentPadding = PaddingValues(top = 112.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                uiState.value.basicCountry?.size?.let { list ->
                    items(list) {
                        CountryCard(uiState.value.basicCountry!![it])
                    }
                }
            }
        }
    }
}