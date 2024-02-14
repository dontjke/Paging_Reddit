package com.stepanov.pagingreddit.repository.dto


import com.google.gson.annotations.SerializedName
import com.stepanov.pagingreddit.repository.HotPost

data class HotPostDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("score")
    val score: Int,
)

fun HotPostDTO.toHotPost(): HotPost {
    return HotPost(
        this.id,
        this.title,
        this.numComments,
        this.score
    )
}