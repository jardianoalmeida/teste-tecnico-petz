package com.jardiano.petz.domain.repository

import com.jardiano.petz.domain.entity.HearthStone

interface HearthstoneRepository {
    suspend fun getHearthstoneList(): List<HearthStone>
}