package com.stepanov.pagingreddit.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stepanov.pagingreddit.repository.ApiService
import com.stepanov.pagingreddit.repository.HotPost
import com.stepanov.pagingreddit.repository.dto.toHotPost
import okio.IOException
import retrofit2.HttpException

class RedditPagingSource(private val apiService: ApiService) : PagingSource<String, HotPost>() {
    override fun getRefreshKey(state: PagingState<String, HotPost>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, HotPost> {

        return try {
            val response = apiService.loadValue(
                count = params.loadSize,
                after = params.key.toString(),
                before = null
            )

            val listing = response.body()?.data
            val redditPosts = listing?.children?.map { it.data.toHotPost() }
            LoadResult.Page(
                redditPosts ?: listOf(),
                listing?.before,
                listing?.after
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}