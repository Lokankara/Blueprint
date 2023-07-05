package com.solution;

import java.util.Scanner;
import java.util.Stack;

public class Cyclic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isCyclic(graph, i, visited, stack)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isCyclic(int[][] graph, int v, boolean[] visited, boolean[] stack) {
        Stack<Integer> dfsStack = new Stack<>();
        dfsStack.push(v);
        while (!dfsStack.isEmpty()) {
            v = dfsStack.peek();
            if (!visited[v]) {
                visited[v] = true;
                stack[v] = true;
            } else {
                stack[v] = false;
                dfsStack.pop();
                continue;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[v][i] == 1) {
                    if (!visited[i]) {
                        dfsStack.push(i);
                    } else if (stack[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
