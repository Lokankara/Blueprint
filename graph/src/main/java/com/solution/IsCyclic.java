package com.solution;

import java.util.Scanner;

public class IsCyclic {
    private static int n;
    private static int[][] graph;
    private static boolean isCycle;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        isCycle = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                if (isCycle) {
                    break;
                }
            }
        }

        System.out.println(isCycle ? 1 : 0);
    }

    private static void dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1) {
                if (!visited[i]) {
                    dfs(i);
                } else {
                    isCycle = true;
                    return;
                }
            }
        }
    }
}
