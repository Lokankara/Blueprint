package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;

public class QueenMoves {

    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] queens;
        for (int t = 0; t < n; t++) {
            queens = new int[8];
            for (int i = 0; i < 8; i++) {
                queens[i] = scanner.nextInt() - 1;
            }
            writer.print(permute(queens, new int[8], new int[15], new int[15], 0, 0, Integer.MAX_VALUE));
            writer.flush();
        }
    }

    private static int permute(int[] queens, int[] row, int[] black, int[] white, int col, int moves, int minMoves) {
        if (col == 8) {
            return Math.min(minMoves, moves);
        }
        for (int r = 0; r < 8; r++) {
            if (row[r] == 0 && black[r + col] == 0 && white[r - col + 7] == 0) {
                row[r] = black[r + col] = white[r - col + 7] = 1;
                minMoves = permute(queens, row, black, white, col + 1, moves + (queens[col] == r ? 0 : 1), minMoves);
                row[r] = black[r + col] = white[r - col + 7] = 0;
            }
        }
        return minMoves;
    }
}
