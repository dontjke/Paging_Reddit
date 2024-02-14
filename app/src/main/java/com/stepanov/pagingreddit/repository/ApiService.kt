package com.stepanov.pagingreddit.repository


import com.stepanov.pagingreddit.repository.dto.ResponseApi
import com.stepanov.pagingreddit.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET(END_POINT)
    fun loadValue(currentPage: Int): Response<ResponseApi>
}

//interface ApiService {
//    @GET(END_POINT)
//    fun loadValue(
//    ): Call<ResponseApi>
//
//}





//interface ApiService {
//    @GET("top?limit=50")
//    fun loadValue(
//        @Query("after") after: String,
//        @Query("before") before: String,
//        @Query("count") count: Int
//    ): Response<ResponseApi>
//}


