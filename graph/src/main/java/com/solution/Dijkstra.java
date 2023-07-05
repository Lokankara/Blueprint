package com.solution;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        int distance = dijkstra(adjacencyMatrix, e, v);
        System.out.println(distance);
    }

    private static int dijkstra(int[][] matrix, int source, int destination) {
        int n = matrix.length;
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[source] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int min = findMinVertex(weight, visited);
            visited[min] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[min][j] >= 0 && weight[min] != Integer.MAX_VALUE) {
                    int distance = weight[min] + matrix[min][j];
                    if (distance < weight[j]) {
                        weight[j] = distance;
                    }
                }
            }
        }
        return (weight[destination]
                == Integer.MAX_VALUE)
                ? -1
                : weight[destination];
    }

    private static int findMinVertex(int[] weight, boolean[] visited) {
        int shortest = -1;
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (shortest == -1 || weight[i] < weight[shortest])) {
                shortest = i;
            }
        }
        return shortest;
    }
}
