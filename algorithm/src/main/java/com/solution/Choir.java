package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class Choir {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        int n, m;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            writer.println(gcd(n, m) == 1 ? "YES" : "NO");
        }
        writer.close();
    }

    public static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
