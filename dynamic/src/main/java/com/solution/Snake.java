package com.solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Snake {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][n];

        int number = 1;
        int row = 0;
        int col = 0;
        int direction = 1;

        while (number <= n * n) {
            matrix[row][col] = number++;

            if (direction == 1) {
                if (col == n - 1 || matrix[row][col + 1] != 0) {
                    direction = -1;
                    row++;
                } else {
                    col++;
                }
            } else {
                if (col == 0 || matrix[row][col - 1] != 0) {
                    direction = 1;
                    row++;
                } else {
                    col--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                writer.print(matrix[i][j] + " ");
            }
            writer.println();
        }
        writer.flush();
        writer.close();
    }
}