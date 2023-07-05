package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class Tree {
    static int[][] matrix = new int[101][101];
    static int[] branch = new int[101];
    static int node, edge = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        String result = "YES";
        node = scanner.nextInt();

        for (int i = 1; i <= node; i++) {
            for (int j = 1; j <= node; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 1) {
                    edge++;
                }
            }
        }
        if (node - 1 != edge / 2) {
            result = "NO";
        }
        dfs(1);
        for (int i = 1; i <= node; i++) {
            if (branch[i] == 0) {
                result = "NO";
                break;
            }
        }
        writer.println(result);
        writer.close();
    }

    public static void dfs(int i) {
        branch[i] = 1;
        for (int j = 1; j <= node; j++) {
            if (matrix[i][j] == 1 && branch[j] == 0) {
                dfs(j);
            }
        }
    }
}
