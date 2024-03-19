package com.solution;

import java.util.Scanner;

public class AngleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        double dot = x1 * x2 + y1 * y2;
        double a = Math.sqrt(x1 * x1 + y1 * y1);
        double b = Math.sqrt(x2 * x2 + y2 * y2);
        double angle = Math.acos(dot / (a * b));
        if (angle < 0) {
            angle += Math.PI;
        }
        System.out.printf("%.5f\n", angle);
    }
}
