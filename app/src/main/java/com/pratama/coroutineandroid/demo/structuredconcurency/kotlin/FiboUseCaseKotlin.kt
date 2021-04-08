package com.pratama.coroutineandroid.demo.structuredconcurency.kotlin

import kotlinx.coroutines.*
import java.math.BigInteger

class FiboUseCaseKotlin(private val dispatcher: CoroutineDispatcher) {

    interface Callback {
        fun onFiboComputed(result: BigInteger?)
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun computeFibo(index: Int, callback: Callback) {
        coroutineScope.launch {
            val result = computeFiboBg(index)
            callback.onFiboComputed(result)
        }
    }

    private suspend fun computeFiboBg(index: Int): BigInteger = withContext(dispatcher) {
        when (index) {
            0 -> {
                BigInteger("0")
            }
            1 -> {
                BigInteger("1")
            }
            else -> {
                computeFiboBg(index - 1).add(computeFiboBg(index - 2))
            }
        }

    }
}