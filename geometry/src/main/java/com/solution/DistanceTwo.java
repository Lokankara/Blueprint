package com.solution;

import java.util.Scanner;

public class DistanceTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        double distance = findDistance(x1, y1, x2, y2, x3, y3, x4, y4);
        System.out.printf("%.6f%n", distance);
    }

    private static double findDistance(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3,
            int x4, int y4) {

        double d1 = find(x1, y1, x2, y2, x3, y3, x4, y4);
        double d2 = find(x3, y3, x4, y4, x1, y1, x2, y2);
        return Math.min(d1, d2);
    }

    private static double find(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3,
            int x4, int y4) {

        int dx1 = x2 - x1;
        int dy1 = y2 - y1;
        int dx2 = x4 - x3;
        int dy2 = y4 - y3;
        int dx3 = x1 - x3;
        int dy3 = y1 - y3;

        int p1 = dx1 * dx2 + dy1 * dy2;
        int p2 = dx1 * dx3 + dy1 * dy3;
        int sd1 = dx1 * dx1 + dy1 * dy1;
        int sd2 = dx2 * dx2 + dy2 * dy2;

        int c = sd1 * sd2 - p1 * p1;

        if (c == 0) {
            return calculate(x1, y1, x3, y3, x4, y4);
        }

        double t1 = (p1 * p2 - sd2 * (dx3 * dx1 + dy3 * dy1)) / c;

        return !(t1 < 0) ? t1 > 1
                ? calculate(x2, y2, x3, y3, x4, y4)
                : calculate((x1 + t1 * dx1), (y1 + t1 * dy1), x3, y3, x4, y4)
                : calculate(x1, y1, x3, y3, x4, y4);
    }

    private static double calculate(
            double px, double py,
            double x1, double y1,
            double x2, double y2) {

        double a = x2 - x1;
        double b = y2 - y1;

        double p = (px - x1) * a + (py - y1) * b;

        if (p <= 0) {
            return calculateDistance(px, py, x1, y1);
        }

        double c = a * a + b * b;

        if (p >= c) {
            return calculateDistance(px, py, x2, y2);
        }

        double t = p / c;
        double ix = x1 + t * a;
        double iy = y1 + t * b;
        return calculateDistance(px, py, ix, iy);
    }

    private static double calculateDistance(
            double x1, double y1,
            double x2, double y2) {

        double a = x2 - x1;
        double b = y2 - y1;
        return Math.sqrt(a * a + b * b);
    }
}
