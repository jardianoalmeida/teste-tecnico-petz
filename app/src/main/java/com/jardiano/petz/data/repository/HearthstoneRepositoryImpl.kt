package com.jardiano.petz.data.repository

import androidx.paging.ExperimentalPagingApi
import com.jardiano.petz.data.remote.HearthstoneCloudStore
import com.jardiano.petz.data.remote.entity.toDomain
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.domain.repository.HearthstoneRepository

@ExperimentalPagingApi
class HearthstoneRepositoryImpl(private val remote: HearthstoneCloudStore) : HearthstoneRepository {
    override suspend fun getHearthstoneList(): List<HearthStone> {
        return remote.getHearthstoneResponse().Basic.map { it.toDomain() }
    }
}