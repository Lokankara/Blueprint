package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GetTree {
    static int node, edge;
    static List<Integer>[] matrix;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        node = scanner.nextInt();
        edge = scanner.nextInt();
        matrix = new List[node];
        IntStream.range(0, node).forEach(i -> matrix[i] = new ArrayList<>());
        for (int i = 0; i < edge; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            matrix[u].add(v);
            matrix[v].add(u);
        }
        visited = new boolean[node];
        dfs(0);
    }

    public static void dfs(int i) {
        visited[i] = true;
        for (int next : matrix[i]) {
            if (!visited[next]) {
                System.out.printf("%d %d%n", i + 1, next + 1);
                dfs(next);
            }
        }
    }
}
