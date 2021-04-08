package com.pratama.coroutineandroid.demo.structuredconcurency.java;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;

public class FiboUseCaseTest {

    FiboUseCase cut;

    @Before
    public void setUp() throws Exception {
        cut = new FiboUseCase();
    }

    @Test
    public void computfibo_0_return_0() {
        BigInteger result = cut.computFibo(0);
        MatcherAssert.assertThat(result, is(new BigInteger("0")));
    }

    @Test
    public void computfibo_1_return_1() {
        BigInteger result = cut.computFibo(1);
        MatcherAssert.assertThat(result, is(new BigInteger("1")));
    }

    @Test
    public void computfibo_7_return_13() {
        BigInteger result = cut.computFibo(7);
        MatcherAssert.assertThat(result, is(new BigInteger("13")));
    }

    @Test
    public void computfibo_30_returnCorrectAnswer() {
        BigInteger result = cut.computFibo(30);
        MatcherAssert.assertThat(result, is(new BigInteger("832040")));
    }

    @Test
    public void computfibo_50_returnCorrectAnswer() {
        BigInteger result = cut.computFibo(50);
        MatcherAssert.assertThat(result, is(new BigInteger("832040")));
    }
}