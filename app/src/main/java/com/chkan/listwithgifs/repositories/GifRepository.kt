package com.chkan.listwithgifs.repositories

import android.util.Log
import com.chkan.listwithgifs.network.Api
import com.chkan.listwithgifs.network.ApiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class GifRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    suspend fun getGifList(): ApiResult {
        val deferred = scope.async {
            val result: ApiResult = try {
                val list = Api.retrofitService.getListGifts().listGifts
                ApiResult.Success(list)
            }catch (e: Exception) {
                ApiResult.Error(e)
            }
            result
        }
        return deferred.await()
    }
}