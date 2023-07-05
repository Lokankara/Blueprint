package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class Stepan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t1 = scanner.nextLong();
        long t2 = scanner.nextLong();

        PrintWriter writer = new PrintWriter(System.out);
        writer.println(lcm(t1, t2));
        writer.flush();
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
