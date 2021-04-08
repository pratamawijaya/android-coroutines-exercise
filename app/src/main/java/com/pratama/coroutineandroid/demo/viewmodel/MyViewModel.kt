package com.pratama.coroutineandroid.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

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
        _isTrackingTime.postValue(false)
    }

    private fun startTracking() = viewModelScope.launch {
        _isTrackingTime.postValue(true)

        val startTimeNano = System.nanoTime()
        while (true) {
            val elapsedTime = (System.nanoTime() - startTimeNano) / 1_000_000_000L
            _elapsedTime.postValue(elapsedTime)
            delay(1_000)
        }
    }

}