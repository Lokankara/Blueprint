package com.solution;

import java.util.Scanner;

public class DistancePointSegment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double px = scanner.nextDouble();
        double py = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double distance = findDistance(px, py, x1, y1, x2, y2);
        System.out.printf("%.5f%n", distance);
    }

    private static double findDistance(
            double px, double py,
            double x1, double y1,
            double x2, double y2) {

        double a = x2 - x1;
        double b = y2 - y1;

        if (a == 0 && b == 0) {
            return calculateDistance(px, py, x1, y1);
        }

        double t = ((px - x1) * a + (py - y1) * b)
                / (a * a + b * b);

        return !(t < 0)
                ? t > 1
                ? calculateDistance(px, py, x2, y2)
                : calculateDistance(px, py, (x1 + t * a), (y1 + t * b))
                : calculateDistance(px, py, x1, y1);
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double a = x2 - x1;
        double b = y2 - y1;
        return Math.sqrt(a * a + b * b);
    }
}
