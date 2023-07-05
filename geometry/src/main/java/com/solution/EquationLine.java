package com.solution;

import java.util.Scanner;

public class EquationLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = -(a * x + b * y);
        System.out.printf("%d %d %d%n", a, b, c);
    }
}
