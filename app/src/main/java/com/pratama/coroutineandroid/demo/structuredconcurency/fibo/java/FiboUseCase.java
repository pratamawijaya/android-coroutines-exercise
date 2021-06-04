package com.pratama.coroutineandroid.demo.structuredconcurency.fibo.java;

import java.math.BigInteger;

public class FiboUseCase {

    public BigInteger computFibo(int index) {
        if (index == 0) {
            return new BigInteger("0");
        } else if (index == 1) {
            return new BigInteger("1");
        } else {
            return computFibo(index - 1).add(computFibo(index - 2));
        }
    }
}
