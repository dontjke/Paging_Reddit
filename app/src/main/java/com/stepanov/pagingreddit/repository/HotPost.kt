package com.stepanov.pagingreddit.repository

data class HotPost (
    val id: String,
    val title: String,
    val numComments: Int,
    val score: Int
)