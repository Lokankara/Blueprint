package com.solution;

import java.util.Scanner;

public class LinePoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int p = a * x + b * y + c;
        System.out.println((p == 0 ? "YES" : "NO"));
    }
}
