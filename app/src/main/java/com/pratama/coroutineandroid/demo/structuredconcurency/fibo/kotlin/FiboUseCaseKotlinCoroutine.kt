package com.pratama.coroutineandroid.demo.structuredconcurency.fibo.kotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigInteger

class FiboUseCaseKotlinCoroutine {

    suspend fun computeFibo(index: Int): BigInteger = withContext(Dispatchers.Default) {
        when (index) {
            0 -> {
                BigInteger("0")
            }
            1 -> {
                BigInteger("1")
            }
            else -> {
                computeFibo(index - 1).add(computeFibo(index - 2))
            }
        }
    }

    /**
     * blazing fast fibo
     *
     * https://kousenit.org/2019/11/26/fibonacci-in-kotlin/
     */
    suspend fun compute(index: Int): BigInteger {

        return withContext(Dispatchers.Default) {
//        (2 until index).fold(1 to 1) { (f, s), _ -> s to (f + s) }.second

            // debug
            val result = (2 until index).fold(1 to 1) { (prev, curr), _ ->
                println("prev=$prev, curr=$curr")
                curr to (prev + curr)
            }.second

            BigInteger(result.toString())
        }
    }
}