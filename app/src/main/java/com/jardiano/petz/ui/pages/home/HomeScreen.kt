package com.jardiano.petz.ui.pages.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.ui.component.ItemCard

@Composable
internal fun HomeScreen(homeViewModel: HomeViewModel, goToDetails: (HearthStone) -> Unit) {

    val lazyItems = homeViewModel.hearthStoneList
    Column(modifier = Modifier.fillMaxSize()) {

        if (lazyItems.isEmpty())
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) { CircularProgressIndicator() }


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            itemsIndexed(items = lazyItems) { _, item ->
                ItemCard(item = item, onClick = goToDetails)
            }
        }
    }
}
