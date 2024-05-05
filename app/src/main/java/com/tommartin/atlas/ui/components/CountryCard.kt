package com.tommartin.atlas.ui.components

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.People
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.tommartin.atlas.data.model.BasicCountry

@Composable
fun CountryCard(
    basicCountry: BasicCountry,
    navHostController: NavHostController
) {
    OutlinedCard(
        onClick = { navHostController.navigate("detail_screen/${basicCountry.name.official}") },
        modifier = Modifier
            .height(224.dp)
            .padding(horizontal = 12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth()) {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(basicCountry.flags.svg)
                        .decoderFactory(SvgDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
            ) {
                Text(
                    text = if (basicCountry.name.common == "Falkland Islands") "Islas Malvinas" else basicCountry.name.common,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 2
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.People,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = NumberFormat.getNumberInstance().format(basicCountry.population),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}