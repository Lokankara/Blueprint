package com.solution;

import java.util.Scanner;

public class Ray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int kx = x1 - x2;
        int ky = y1 - y2;
        int bx = x3 - x2;
        int by = y3 - y2;

        System.out.println(kx * by - ky * bx == 0 && kx * bx + ky * by >= 0 ? "YES" : "NO");
    }
}