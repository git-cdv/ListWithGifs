package com.chkan.listwithgifs.ui.listview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chkan.listwithgifs.model.Gif
import com.chkan.listwithgifs.network.ApiResult
import com.chkan.listwithgifs.repositories.GifRepository
import kotlinx.coroutines.launch


class ListViewModel : ViewModel() {

    private val gifRepo = GifRepository()

    private val _apiResult = MutableLiveData<ApiResult>()
    val apiResult: LiveData<ApiResult>
        get() = _apiResult

    private val _navToSelectedGif = MutableLiveData<Gif?>()
    val navToSelectedGif : MutableLiveData<Gif?>
        get() = _navToSelectedGif

    fun getGifList() {
        viewModelScope.launch {
            _apiResult.value =  gifRepo.getGifList()
            Log.d("MYLOGS", "ListViewModel : apiResult ->${_apiResult.value}")
        }

    }

    fun displayGiftDetails(gif: Gif) {
        _navToSelectedGif.value = gif
    }

    fun displayGifDetailsComplete() {
        _navToSelectedGif.value = null
    }

}