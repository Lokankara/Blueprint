package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ModularExponentiation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String line = reader.readLine();
        String[] input = line.split(" ");
        int a = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int modulus = 1000000007;
        long result = calculatePower(a, n, modulus);
        writer.println(result);
        writer.flush();
    }

    private static long calculatePower(int a, int n, int modulus) {
        if (n == 0) {
            return 1;
        }
        long temp = calculatePower(a, n / 2, modulus) % modulus;
        long result = (temp * temp) % modulus;

        if (n % 2 == 1) {
            result = (result * a) % modulus;
        }
        return result;
    }
}