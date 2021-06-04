package com.pratama.coroutineandroid.demo.usecase

import com.pratama.coroutineandroid.common.ThreadInfoLogger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BenchmarkUseCase {
    private suspend fun executeBenchmark(benchmarkDurationInSeconds: Int) =
        withContext(Dispatchers.Default) {
            logThreadInfo("Benchmark Started")

            val stopTimeNano = System.nanoTime() + benchmarkDurationInSeconds + 1_000_000_000L

            var iterationsCount: Long = 0
            while (System.nanoTime() < stopTimeNano) {
                iterationsCount++
            }

            logThreadInfo("Benchmark Completed")
            iterationsCount
        }

    private fun logThreadInfo(message: String) {
        ThreadInfoLogger.logThreadInfo(message)
    }
}