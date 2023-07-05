package com.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<int[]>[] adjacency = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacency[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            adjacency[a].add(new int[]{b, c});
            adjacency[b].add(new int[]{a, c});
        }

        int minTree = findMinTree(n, adjacency);
        System.out.println(minTree);
    }

    private static int findMinTree(int n, List<int[]>[] adjacencyList) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

        int min = 0;
        int start = 1;

        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int vertex = edge[0];
            int weight = edge[1];

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            min += weight;

            adjacencyList[vertex].stream()
                    .filter(neighbor -> !visited[neighbor[0]])
                    .map(neighbor -> new int[]{neighbor[0], neighbor[1]})
                    .forEach(queue::offer);
        }
        return min;
    }
}