package com.solution;

import java.util.Scanner;

public class Intersection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double A1 = scanner.nextDouble();
        double B1 = scanner.nextDouble();
        double C1 = scanner.nextDouble();
        double A2 = scanner.nextDouble();
        double B2 = scanner.nextDouble();
        double C2 = scanner.nextDouble();

        double a = C2 * B1 - C1 * B2;
        double b = A2 * C1 - A1 * C2;
        double d = A1 * B2 - A2 * B1;

        double x;
        double y;

        if (d == 0) {
            x = 0;
            y = 0;
        } else if (a == 0 && b != 0) {
            x = 0;
            y = b / d;
        } else if (b == 0 && a != 0) {
            x = a / d;
            y = 0;
        } else {
            x = a / d;
            y = b / d;
        }
        System.out.printf("%.2f %.2f%n", x, y);
    }
}
