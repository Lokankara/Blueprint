package com.solution;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GraphCycle {
    private static int n;
    private static int[][] matrix;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        matrix = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int hasCycle = hasCycle() ? 1 : 0;
        System.out.println(hasCycle);
    }

    private static boolean hasCycle() {
        return IntStream.range(0, n)
                .anyMatch(i -> !visited[i] && dfs(i, i));
    }

    private static boolean dfs(int a, int b) {
        visited[b] = true;
        for (int i = 0; i < n; i++) {
            if (matrix[b][i] == 1) {
                if (visited[i]) {
                    if (i == a) {
                        return true;
                    }
                } else if (dfs(a, i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
