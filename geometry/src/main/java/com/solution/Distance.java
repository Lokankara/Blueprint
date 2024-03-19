package com.solution;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int a = x3 - x2;
        int b = y2 - y3;
        int c = x2 * y3 - x3 * y2;
        double numerator = Math.abs((b) * x1 + (a) * y1 + c);
        double denominator = Math.sqrt(Math.pow(b, 2) + Math.pow(a, 2));
        double distance = numerator / denominator;
        System.out.printf("%.6f", distance);
    }
}

class DistanceToLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int numerator = Math.abs(a * x + b * y + c);
        double denominator = Math.sqrt(a * a + b * b);
        double distance = numerator / denominator;
        System.out.printf("%.8f%n", distance);
    }
}