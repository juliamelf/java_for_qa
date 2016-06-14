package ru.juliamelf.javaqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Julia on 6/14/2016.
 */
public class PrimeTests {

    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrime() {
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }

    @Test
    public void testPrimeFast() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testNonPrimeFast() {
        Assert.assertFalse(Primes.isPrimeFast(Integer.MAX_VALUE-2));
    }
}
