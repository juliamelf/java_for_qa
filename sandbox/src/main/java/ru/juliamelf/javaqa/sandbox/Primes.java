package ru.juliamelf.javaqa.sandbox;

/**
 * Created by Julia on 6/14/2016.
 */
public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return  true;
    }

    public static boolean isPrimeFast(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i < m; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return  true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2;
        while (i<n) {
            if (n%i == 0) {
                return false;
            }
            i++;
        }

        return  true;
    }
}
