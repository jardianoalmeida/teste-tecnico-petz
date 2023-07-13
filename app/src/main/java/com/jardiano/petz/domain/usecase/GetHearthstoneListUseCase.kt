package com.jardiano.petz.domain.usecase

import com.jardiano.petz.domain.repository.HearthstoneRepository

class GetHearthstoneListUseCase(private val repository: HearthstoneRepository) {
     suspend operator fun invoke() = repository.getHearthstoneList()
}