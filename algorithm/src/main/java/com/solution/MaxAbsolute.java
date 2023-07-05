package com.solution;

import java.util.Scanner;

public class MaxAbsolute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double maxAbsolute = Math.abs(scanner.nextDouble());
        for (int i = 1; i < n; i++) {
            double absolute = Math.abs(scanner.nextDouble());
            if (absolute > maxAbsolute) {
                maxAbsolute = absolute;
            }
        }
        System.out.printf("%.2f%n", maxAbsolute);
    }
}
