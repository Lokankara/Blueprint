package com.solution;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Floyd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int[] groups = IntStream.range(0, n)
                .map(i -> 1).toArray();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    groups[i] -= 1;
                    groups[j] -= 1;
                }
            }
        }

        boolean isPartition = IntStream.range(0, n)
                .noneMatch(i -> groups[i] != 0);

        System.out.println(isPartition ? "YES" : "NO");
    }
}
