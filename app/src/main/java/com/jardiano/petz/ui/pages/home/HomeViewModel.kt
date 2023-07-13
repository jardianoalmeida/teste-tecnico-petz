package com.jardiano.petz.ui.pages.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.domain.usecase.GetHearthstoneListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getHearthstoneListUseCase: GetHearthstoneListUseCase,
) : ViewModel() {
    init {
        showList()
    }

    var hearthStoneList: List<HearthStone> by mutableStateOf(listOf())

    private fun showList() {
        viewModelScope.launch(Dispatchers.IO) {
            hearthStoneList = getHearthstoneListUseCase()
        }
    }
}
