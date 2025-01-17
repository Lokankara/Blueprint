package com.solution;

import java.util.Scanner;

public class VectorLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int y2 = scanner.nextInt();

        int a = x2 - x1;
        int b = y2 - y1;
        int c = a * a + b * b;
        double length = Math.sqrt(c);
        System.out.printf("%.6f\n", length);
    }
}