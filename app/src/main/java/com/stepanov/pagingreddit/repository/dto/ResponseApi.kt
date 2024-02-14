package com.stepanov.pagingreddit.repository.dto


import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("data")
    val data: DataDTO,
    @SerializedName("kind")
    val kind: String
)
