package com.solution;

import java.util.Scanner;

public class IntersectionLine {

    public static boolean intersects(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3,
            int x4, int y4) {

        int a = x2 - x1;
        int b = y3 - y1;
        int c = y2 - y1;
        int d = x3 - x1;
        int e = x4 - x3;
        int f = y4 - y3;

        int d1 = a * b - c * d;
        int d2 = e * b - f * d;
        int d3 = e * c - f * a;
        int d4 = a * c - c * a;
        return d1 * d2 >= 0 && d3 * d4 >= 0;
    }

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
        boolean intersects = intersects(x1, y1, x2, y2, x3, y3, x4, y4);
        System.out.println(intersects ? "YES" : "NO");
    }
}
