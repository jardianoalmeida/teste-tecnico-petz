package com.jardiano.petz.ui.pages.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.util.verticalGradientScrim

@Composable
fun DetailScreen(hearthStone: HearthStone, onBackPressed: () -> Unit) {
    Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary)) {
        DetailContent(
            item = hearthStone,
            onBackPressed = onBackPressed,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
        Footer(
            Modifier.align(Alignment.BottomCenter), onBackPressed
        )
    }
}

@Composable
fun DetailContent(item: HearthStone, onBackPressed: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Box {
            AsyncImage(
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 5f)
                    .background(Color(0xFF2A3038))

            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .verticalGradientScrim(
                        color = Color.Black.copy(alpha = 0.3f),
                        startYPercentage = 1f,
                        endYPercentage = 0f
                    )
            )
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Sair",
                    tint = Color.White
                )
            }
        }
        ItemDescription("Nome", item.name)
        item.flavor?.let { ItemDescription("Descrição flavor", it) }
        ItemDescription("Set pertencente", item.cardSet)
        ItemDescription("Tipo", item.type)
        item.faction?.let { ItemDescription("Facção", it) }
        item.rarity?.let { ItemDescription("Raridade", it) }
        ItemDescription("Ataque", item.attack.toString())
        ItemDescription("Custo", item.cost.toString())
        ItemDescription("Health", item.health.toString())
    }
}

@Composable
fun ItemDescription(name: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Composable
fun Footer(modifier: Modifier,  onBackPressed: () -> Unit) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.onPrimary
    ) {
            Button(
                onClick = onBackPressed,
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxSize()
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Voltar",
                    color = Color.White
                )
            }
    }
}



