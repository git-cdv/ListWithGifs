package com.chkan.listwithgifs.network

import com.chkan.listwithgifs.model.Gif

sealed class ApiResult{
    class Success (val data: List<Gif>) : ApiResult()
    class Error(val e: Exception) : ApiResult()
}
