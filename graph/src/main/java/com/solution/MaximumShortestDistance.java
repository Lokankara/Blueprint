package com.solution;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumShortestDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int max = findMax(matrix);
        System.out.println(max);
    }

    private static int findMax(int[][] graph) {
        int n = graph.length;
        int[][] visited = new int[n][n];
        IntStream.range(0, n).forEach(i -> System.arraycopy(graph[i], 0, visited[i], 0, n));

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][k] != -1 && visited[k][j] != -1) {
                        if (visited[i][j] == -1 || visited[i][k] + visited[k][j] > visited[i][j]) {
                            visited[i][j] = visited[i][k] + visited[k][j];
                        }
                    }
                }
            }
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != -1 && visited[i][j] > min) {
                    min = visited[i][j];
                }
            }
        }
        return min;
    }
}