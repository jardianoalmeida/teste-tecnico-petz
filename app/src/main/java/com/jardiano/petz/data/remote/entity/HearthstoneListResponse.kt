package com.jardiano.petz.data.remote.entity

import com.google.gson.annotations.SerializedName
import com.jardiano.petz.domain.entity.HearthStone

data class HearthstoneListResponse(
    val Basic: List<HearthstoneResponse>,
)

data class HearthstoneResponse(
    val name: String,
    @SerializedName("img") var image: String?,
    val type: String,
    val faction: String?,
    val rarity: String?,
    val cardSet: String,
    val flavor: String?,
    val health: Int,
    val attack: Int,
    val cost: Int
)


fun HearthstoneResponse.toDomain(): HearthStone {
    return HearthStone(
        name,
        image,
        type,
        rarity,
        faction,
        cardSet,
        flavor,
        health,
        attack,
        cost,
    )
}


