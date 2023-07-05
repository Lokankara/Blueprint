package com.solution;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] adjMatrix = new int[n][n];
        IntStream.range(0, m).forEach(i -> adjMatrix[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

