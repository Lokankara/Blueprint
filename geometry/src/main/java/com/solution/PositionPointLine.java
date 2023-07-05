package com.solution;

import java.util.Scanner;

public class PositionPointLine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int p1 = a * x1 + b * y1 + c;
        int p2 = a * x2 + b * y2 + c;
        System.out.println((p1 == p2 ? "YES" : "NO"));
    }
}

