package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

import static java.math.BigInteger.valueOf;

public class AlarmClocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        writer.println(valueOf(n).multiply(valueOf(m)).divide(valueOf(n).gcd(valueOf(m))));
        writer.flush();
    }
}
