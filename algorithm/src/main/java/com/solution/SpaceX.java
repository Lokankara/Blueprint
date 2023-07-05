package com.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpaceX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] p = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] freq = new int[100001];
        for (int i = 0; i < n; i++) {
            freq[p[i]]++;
        }

        Arrays.sort(freq);

        int changes = 0;
        for (int i = freq.length - 1; i >= freq.length - k; i--) {
            changes += freq[i];
        }

        writer.println(changes);
    }
}