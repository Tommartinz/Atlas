package com.tommartin.atlas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.tommartin.atlas.data.model.BasicCountry
import com.tommartin.atlas.data.model.submodels.CountryName
import com.tommartin.atlas.data.model.submodels.Flags
import com.tommartin.atlas.ui.components.CountryCard
import com.tommartin.atlas.ui.components.SearchBarComponent

@Composable
fun HomeScreen() {
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
                items(50) {
                    CountryCard()
                }
            }
        }
    }
}