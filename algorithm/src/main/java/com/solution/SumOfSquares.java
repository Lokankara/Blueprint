package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.math.BigInteger;

public class SumOfSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = reader.readLine().split(" ");

        writer.println(calculate(
                new BigInteger(input[0]),
                new BigInteger(input[1])));
        writer.flush();
        writer.close();
    }

    private static BigInteger calculate(
            BigInteger a, BigInteger b) {
        return a.multiply(a).add(b.multiply(b));
    }
}
