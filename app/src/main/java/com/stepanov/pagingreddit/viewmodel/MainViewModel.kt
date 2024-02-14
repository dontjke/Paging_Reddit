package com.stepanov.pagingreddit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.stepanov.pagingreddit.paging.RedditPagingSource
import com.stepanov.pagingreddit.repository.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        RedditPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}