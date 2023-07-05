package com.solution;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double a = y2 - y1;
        double b = x1 - x2;
        double c = x1 * y2 - x2 * y1;
        double d = Math.abs(a * x + b * y + c) / Math.sqrt(a * a + b * b);

        System.out.printf("%.6f\n", d);
    }
}
