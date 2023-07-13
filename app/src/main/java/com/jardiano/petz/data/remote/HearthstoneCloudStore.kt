package com.jardiano.petz.data.remote

import com.jardiano.petz.core.ApiException
import com.jardiano.petz.data.remote.api.PetzApi
import com.jardiano.petz.data.remote.entity.HearthstoneListResponse

class HearthstoneCloudStore(private val api: PetzApi) {
    suspend fun getHearthstoneResponse(): HearthstoneListResponse {
        val response = api.getHearthstones()
        return try {
            response
        } catch (e: Exception) {
            throw ApiException()
        }
    }
}