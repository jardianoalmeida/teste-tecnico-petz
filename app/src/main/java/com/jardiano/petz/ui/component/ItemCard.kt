package com.jardiano.petz.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jardiano.petz.domain.entity.HearthStone

@Composable
fun ItemCard(
    item: HearthStone,
    onClick: (HearthStone) -> Unit
) {
    Card(
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(item)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = item.image,
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(4 / 5f)
                    .background(Color(0xFF2A3038))
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 10.dp),
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 8.dp, end = 8.dp, top = 4.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}