package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MirrorPrimes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String line = reader.readLine();
        String[] input = line.split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        boolean[] primes = sieveOfEratosthenes(b);

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isMirrorPrime(i, primes)) {
                count++;
            }
        }

        writer.println(count);
        writer.flush();
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }

    private static boolean isMirrorPrime(int number, boolean[] primes) {
        if (number >= primes.length || !primes[number]) {
            return false;
        }

        int reverseNumber = reverseDigits(number);
        return reverseNumber < primes.length && primes[reverseNumber];
    }

    private static int reverseDigits(int number) {
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
