package com.pratama.coroutineandroid.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratama.coroutineandroid.getCurrentThread
import kotlinx.coroutines.*

class MyViewModel : ViewModel() {

    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> = _elapsedTime

    private val _isTrackingTime = MutableLiveData<Boolean>()
    val isTrackingTime: LiveData<Boolean> = _isTrackingTime

    fun toggleTrackElapsedTime() {
        val isTrackingTimeNow = isTrackingTime.value

        if (isTrackingTimeNow == null || !isTrackingTimeNow) {
            startTracking()
        } else {
            stopTracking()
        }
    }

    private fun stopTracking() {
        getCurrentThread("stop tracking")
        _isTrackingTime.postValue(false)
        _elapsedTime.postValue(0)
        viewModelScope.coroutineContext.cancelChildren()
    }

    private fun startTracking() = viewModelScope.launch(Dispatchers.Main) {
        _isTrackingTime.postValue(true)
        getCurrentThread("start tracking")
        val startTimeNano = System.nanoTime()
        while (true) {
            val elapsedTime = (System.nanoTime() - startTimeNano) / 1_000_000_000L
            _elapsedTime.postValue(elapsedTime)
            delay(1_000)
        }
    }

}