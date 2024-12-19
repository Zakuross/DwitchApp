package com.example.dwitchapp.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class OrderResponse(
    val data: List<Order>
)