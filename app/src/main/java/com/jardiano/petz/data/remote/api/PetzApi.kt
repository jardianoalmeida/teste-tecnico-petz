package com.jardiano.petz.data.remote.api

import com.jardiano.petz.data.remote.entity.HearthstoneListResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface PetzApi {
    @GET("cards")
    @Headers(
        "Accept: application/json",
        "X-RapidAPI-Key: edb79a6d19msh214409b5ddae6bap101cd7jsn987a2e44ed0c",
        "X-RapidAPI-Host: omgvamp-hearthstone-v1.p.rapidapi.com"
    )
    suspend fun getHearthstones(): HearthstoneListResponse
}
