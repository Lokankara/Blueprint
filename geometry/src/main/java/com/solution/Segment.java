package com.solution;

import java.util.Scanner;

public class Segment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        int kx = x1 - x2;
        int ky = y1 - y2;
        int bx = x3 - x2;
        int by = y3 - y2;

        boolean isRay = kx * by - ky * bx == 0 && kx * bx + ky * by >= 0;
        boolean isOnSegment = kx * bx + ky * by <= bx * bx + by * by;

        System.out.println(isRay && isOnSegment ? "YES" : "NO");
    }
}
