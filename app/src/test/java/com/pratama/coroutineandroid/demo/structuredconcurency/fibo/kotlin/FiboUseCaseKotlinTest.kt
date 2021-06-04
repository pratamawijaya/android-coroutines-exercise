package com.pratama.coroutineandroid.demo.structuredconcurency.fibo.kotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.math.BigInteger

class FiboUseCaseKotlinTest {


    private lateinit var callback: FiboUseCaseKotlin.Callback
    private lateinit var cut: FiboUseCaseKotlin
    private var lastResult: BigInteger? = null

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)

        cut = FiboUseCaseKotlin(testCoroutineDispatcher)

        callback = object : FiboUseCaseKotlin.Callback {
            override fun onFiboComputed(result: BigInteger?) {
                lastResult = result
            }
        }
    }


    @Test
    fun `compute fibo 10 return 55`() {
        testCoroutineDispatcher.runBlockingTest {
            cut.computeFibo(10, callback)
            assertEquals(lastResult, BigInteger("55"))
        }
    }

    @Test
    fun `compute fibo 15 return correct`() {
        testCoroutineDispatcher.runBlockingTest {
            cut.computeFibo(15, callback)
            assertEquals(lastResult, BigInteger("610"))
        }
    }

    @Test
    fun `compute fibo 30 return correct`() {
        testCoroutineDispatcher.runBlockingTest {
            cut.computeFibo(30, callback)
            assertEquals(lastResult, BigInteger("832040"))
        }
    }
}