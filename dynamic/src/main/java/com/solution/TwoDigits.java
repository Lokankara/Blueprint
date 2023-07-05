package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        writer.println(calculate(scanner.nextInt()));
        writer.close();
    }

    private static int calculate(int n) {
        int f = 0;
        int a = 2;
        int b = 4;

        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 4;
        }

        for (int i = 3; i <= n; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }
}



