package com.stepanov.pagingreddit.repository.dto


import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("after")
    val after: String,
    @SerializedName("before")
    val before: String?,
    @SerializedName("children")
    val children: List<ChildrenDTO>,
    @SerializedName("dist")
    val dist: Int,
    @SerializedName("geo_filter")
    val geoFilter: Any,
    @SerializedName("modhash")
    val modhash: String
)