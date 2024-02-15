package com.stepanov.pagingreddit.repository


import com.stepanov.pagingreddit.repository.dto.ResponseApi
import com.stepanov.pagingreddit.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun loadValue(
        @Query("after") after: String,
        @Query("before") before: String?,
        @Query("count") count: Int
    ): Response<ResponseApi>
}


