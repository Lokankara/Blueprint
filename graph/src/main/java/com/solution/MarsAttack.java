package com.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MarsAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int child;
            while ((child = sc.nextInt()) != 0) {
                graph[i].add(child - 1);
            }
        }
        List<Integer> order = topologicalSort(graph);
        for (int i : order) {
            System.out.print((i + 1) + " ");
        }
    }

    public static List<Integer> topologicalSort(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, order, i);
            }
        }
        Collections.reverse(order);
        return order;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, List<Integer> order, int u) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(graph, visited, order, v);
            }
        }
        order.add(u);
    }
}

