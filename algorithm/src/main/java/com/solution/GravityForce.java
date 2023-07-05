package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class GravityForce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        double x, y, n, k, e, m;

        x = scanner.nextDouble();
        y = scanner.nextDouble();

        n = Math.sqrt(x * x + y * y);
        k = Math.sqrt(Math.pow(384000 - x, 2) + y * y);
        e = 81 / (n * n);
        m = 1 / (k * k);

        writer.println(
                e > m
                ? "Earth"
                : e == m
                ? "Equal"
                : "Moon");
        writer.close();
    }
}
