package com.solution;

import java.util.Scanner;

public class LineEquation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double a = y2 - y1;
        double b = x1 - x2;
        double c = y1 * x2 - y2 * x1;
        System.out.printf("%.0f %.0f %.0f\n", a, b, c);
    }
}
