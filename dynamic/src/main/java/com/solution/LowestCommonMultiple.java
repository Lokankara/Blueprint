package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.math.BigInteger;

public class LowestCommonMultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());
        BigInteger[] numbers = new BigInteger[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = new BigInteger(input[i]);
        }
        writer.println(calculate(numbers));
        writer.flush();
        writer.close();
    }

    private static BigInteger calculate(BigInteger[] numbers) {
        BigInteger lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = lcm(lcm, numbers[i]);
        }
        return lcm;
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }
}
