package com.stepanov.pagingreddit.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stepanov.pagingreddit.repository.ApiService
import com.stepanov.pagingreddit.repository.HotPost
import com.stepanov.pagingreddit.repository.dto.toHotPost

class RedditPagingSource(private val apiService: ApiService) : PagingSource<Int, HotPost>() {
    override fun getRefreshKey(state: PagingState<Int, HotPost>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HotPost> {
        return try {

            val currentPage = params.key ?: 1
            val response = apiService.loadValue(currentPage)
            val data = response.body()?.let { redditDTO ->
                redditDTO.data.children.map {
                    it.data.toHotPost()
                }
            }
            val responseData = mutableListOf<HotPost>()
            data?.let {
                responseData.addAll(it)
            }




            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    }
}