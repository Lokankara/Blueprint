package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class BrutForce {

    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int[] rows = new int[8];
            for (int i = 0; i < 8; i++) {
                rows[i] = scanner.nextInt() - 1;
            }
            int minMoves = Integer.MAX_VALUE;
            int[] perm = {0, 1, 2, 3, 4, 5, 6, 7};
            do {
                int moves = 0;
                for (int i = 0; i < 8; i++) {
                    if (rows[i] != perm[i]) {
                        moves++;
                    }
                }
                boolean valid = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = i + 1; j < 8; j++) {
                        if (Math.abs(i - j) == Math.abs(perm[i] - perm[j])) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) {
                    minMoves = Math.min(minMoves, moves);
                }
            } while (nextPermutation(perm));
            writer.println(minMoves);
            writer.close();
        }
    }

    private static boolean nextPermutation(int[] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                int j = a.length - 1;
                while (a[i] >= a[j]) {
                    j--;
                }
                swap(a, i, j);
                reverse(a, i + 1, a.length - 1);
                return true;
            }
        }
        return false;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}
