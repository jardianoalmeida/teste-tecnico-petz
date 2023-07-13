package com.jardiano.petz.domain.entity

data class HearthStone(
    val name: String,
    val image: String?,
    val type: String,
    val rarity: String?,
    val faction: String?,
    val cardSet: String,
    val flavor: String?,
    val health: Int,
    val attack: Int,
    val cost: Int,
)