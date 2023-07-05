package com.solution;

import java.util.Scanner;

public class Degree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            int inDegree = 0;
            int outDegree = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    outDegree++;
                }
                if (matrix[j][i] == 1) {
                    inDegree++;
                }
            }
            System.out.printf("%d %d%n", inDegree, outDegree);
        }
    }
}