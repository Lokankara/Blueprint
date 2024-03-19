package com.solution;

import java.util.Scanner;

public class BeamDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int a = x2 - x1;
        int b = y2 - y1;
        double c = (x - x1) * a + (y - y1) * b;
        double distance = Math.abs(c) / Math.sqrt(a * a + b * b);
        System.out.printf("%.6f\n", distance);
    }
}
