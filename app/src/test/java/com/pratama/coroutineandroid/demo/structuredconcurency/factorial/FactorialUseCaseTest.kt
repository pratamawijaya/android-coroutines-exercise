package com.pratama.coroutineandroid.demo.structuredconcurency.factorial

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FactorialUseCaseTest {

    private lateinit var cut: FactorialUseCase

    @Before
    fun setUp() {
        cut = FactorialUseCase()
    }

    @Test
    fun `fact 1 should return`() {
        val result = cut.factorial(1)
        assertEquals(result, 1)
    }

    @Test
    fun `fact 10 should return`() {
        val result = cut.factorial(10)
        assertEquals(result, 3628800)
    }

    @Test
    fun `fact 1000 should return`() {
        val result = cut.factorial(1000)
        assertEquals(result, 1)
    }
}