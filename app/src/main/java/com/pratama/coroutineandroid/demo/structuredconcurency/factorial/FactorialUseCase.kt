package com.pratama.coroutineandroid.demo.structuredconcurency.factorial

class FactorialUseCase {

    fun factorial(number: Int): Long {
        return when (number) {
            0 -> 1
            else -> number * factorial(number - 1)
        }
    }
}