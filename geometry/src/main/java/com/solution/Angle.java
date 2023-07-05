package com.solution;

import java.util.Scanner;

public class Angle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        double a = Math.atan2(y, x);
        if (a < 0) {
            a += 2 * Math.PI;
        }
        System.out.printf("%.6f%n", a);
    }
}
