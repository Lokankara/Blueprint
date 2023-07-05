package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class ResizePhoto {
    public static void main(String[] args) {
        String format = "%.3f %.3f%n";
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double w = scanner.nextInt();
        double h = scanner.nextInt();

        double ratio1 = Math.min(w / a, h / b);
        double ratio2 = Math.min(h / a, w / b);
        double ratio = Math.max(ratio1, ratio2);
        writer.printf(format, a * ratio, b * ratio);
        writer.flush();
    }
}
