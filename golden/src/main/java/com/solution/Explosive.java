package com.solution;

import java.util.Scanner;

public class Explosive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] f = new long[Math.max(n + 1, 3)];
        f[1] = 2;
        f[2] = 3;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.print(f[n]);
    }
}
