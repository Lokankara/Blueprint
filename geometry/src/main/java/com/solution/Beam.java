package com.solution;

import java.util.Scanner;

public class Beam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        int a = x1 - x2;
        int b = y1 - y2;
        int c = x3 - x2;
        int d = y3 - y2;

        int p = a * c + b * d;
        int len = c * c + d * d;

        double scalar = (double) p / len;
        double dc = scalar * c;
        double dd = scalar * d;
        double da = a - dc;
        double db = b - dd;

        double distance = p >= 0
                ? Math.sqrt(da * da + db * db)
                : Math.sqrt(a * a + b * b);

        System.out.printf("%.6f", distance);
    }
}