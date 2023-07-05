package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SuitablePairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] nk = reader.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] tStr = reader.readLine().split(" ");

        int[] t = IntStream.range(0, n).map(i -> Integer.parseInt(tStr[i])).toArray();
        k = Math.min(k, n);

        PriorityQueue<Long> queue = IntStream.range(0, k)
                .mapToObj(i -> (long) t[i])
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = k; i < n; i++) {
            if (!queue.isEmpty()) {
                long minTime = queue.poll();
                minTime += t[i];
                queue.add(minTime);
            }
        }

        long totalTime = 0;
        while (!queue.isEmpty()) {
            totalTime = queue.poll();
        }

        writer.println(totalTime);
        writer.flush();
    }
}
