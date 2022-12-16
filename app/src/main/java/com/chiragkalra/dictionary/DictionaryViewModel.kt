package com.chiragkalra.dictionary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.await

class DictionaryViewModel(mApp: Application) : AndroidViewModel(mApp) {

    fun getResults(query: String, callback: (results: List<ResultItem>?) -> Unit) {
        val response = Api.dictionaryApi.getResponse(query)
        viewModelScope.launch(Dispatchers.IO) {
            val results: List<ResultItem>?
            try {
                results = response.await()?.definitions
            } catch (e: HttpException) {
                return@launch
            }
            if (results == null)return@launch
            withContext(Dispatchers.Main) {
                callback(results)
            }
        }
    }
}