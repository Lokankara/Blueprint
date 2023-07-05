package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumVertexSet {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        IntStream.rangeClosed(0, n).forEach(i -> graph.add(new ArrayList<>()));

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        System.out.println(dfs(1));
    }

    static long dfs(int node) {
        visited[node] = true;
        return graph.get(node).stream()
                .mapToInt(neighbor -> neighbor)
                .filter(neighbor -> !visited[neighbor])
                .filter(neighbor -> dfs(neighbor) % 2 == 0)
                .count();
    }
}
