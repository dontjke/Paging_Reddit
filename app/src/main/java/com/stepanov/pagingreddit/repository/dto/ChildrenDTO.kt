package com.stepanov.pagingreddit.repository.dto


import com.google.gson.annotations.SerializedName

data class ChildrenDTO(
    @SerializedName("data")
    val data: HotPostDTO,
    @SerializedName("kind")
    val kind: String
)