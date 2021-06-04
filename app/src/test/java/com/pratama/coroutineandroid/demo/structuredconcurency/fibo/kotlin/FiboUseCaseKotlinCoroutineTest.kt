package com.pratama.coroutineandroid.demo.structuredconcurency.fibo.kotlin

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger

class FiboUseCaseKotlinCoroutineTest {

    private var cut = FiboUseCaseKotlinCoroutine()

    @Test
    fun `compute fibo 0 return 0`() = runBlocking {
        val result = cut.computeFibo(0)
        assertEquals(result, BigInteger("0"))
    }

    @Test
    fun `compute fibo 10 return correct`() = runBlocking {
        val result = cut.computeFibo(10)
        assertEquals(result, BigInteger("55"))
    }

    @Test
    fun `compute fibo 400 return correct`() = runBlocking {
        val result = cut.compute(400)
        assertEquals(result, BigInteger("650574555"))
    }
}
