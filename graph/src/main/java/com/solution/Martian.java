package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Martian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> children = new ArrayList<>(n + 1);
        int[] parents = new int[n + 1];
        List<Integer> order = new ArrayList<>();
        IntStream.rangeClosed(0, n).forEach(i -> children.add(new ArrayList<>()));

        for (int i = 1; i <= n; i++) {
            while (true) {
                int descendant = sc.nextInt();
                if (descendant == 0) {
                    break;
                }
                children.get(i).add(descendant);
                parents[descendant]++;
            }
        }

        Queue<Integer> queue = IntStream.rangeClosed(1, n)
                .filter(i -> parents[i] == 0)
                .boxed()
                .collect(toCollection(LinkedList::new));

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int descendant : children.get(node)) {
                parents[descendant]--;
                if (parents[descendant] == 0) {
                    queue.add(descendant);
                }
            }
        }
        order.stream().map(integer -> integer + " ").forEach(System.out::print);
    }
}
