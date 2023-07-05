package com.solution;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Queen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        IntStream.range(0, scanner.nextInt())
                .map(t -> permute(IntStream.range(0, 8)
                        .map(i -> scanner.nextInt() - 1)
                        .toArray(), new int[8], new boolean[8], 0, 0))
                .forEachOrdered(writer::print);
        writer.close();
    }

    private static int permute(int[] rows, int[] perm, boolean[] used, int k, int moves) {
        if (k != 8) {
            int minMoves = Integer.MAX_VALUE;
            for (int i = 0; i < 8; i++) {
                if (!used[i]) {
                    perm[k] = i;
                    used[i] = true;
                    if (IntStream.range(0, k).noneMatch(j -> Math.abs(k - j) == Math.abs(perm[k] - perm[j]))) {
                        minMoves = Math.min(minMoves, permute(rows, perm, used, k + 1, moves + (rows[k] != perm[k] ? 1 : 0)));
                    }
                    used[i] = false;
                }
            }
            return minMoves;
        } else {
            return moves;
        }
    }
}
