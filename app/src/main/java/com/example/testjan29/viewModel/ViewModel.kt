package com.example.testjan29.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testjan29.api.NewsModel
import com.example.testjan29.api.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel : ViewModel() {

    private val _newsDetails = MutableLiveData<List<NewsModel>>(emptyList())
    val newsDetails: LiveData<List<NewsModel>> = _newsDetails
    private var job: Job? = null

    fun getNewsInfo(country: String, source: String) {

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            val repository = NewsRepository()
            val response = repository.getNewsInfo(country, source)
            withContext(Main) {
                _newsDetails.value = response
            }
        }

    }

}