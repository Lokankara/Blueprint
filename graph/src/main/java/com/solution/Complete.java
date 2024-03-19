package com.solution;

import java.util.Scanner;

public class Complete {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        boolean isComplete = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 1) {
                    isComplete = false;
                    break;
                }
            }
            if (!isComplete) {
                break;
            }
        }

        if (isComplete) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
