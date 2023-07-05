package com.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChessKnight {
    static int n;
    static int[][] cell;
    static int[][] board;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] moves = {-1, 2, -1, -2, 1, 2, 1, -2, -2, 1, -2, -1, 2, 1, 2, -1};

    public static void main(String[] args) {
        int a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        cell = new int[n + 1][n + 1];
        board = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];
        bfs(a, b, c, d);
        System.out.println(board[c][d]);
    }

    public static void bfs(int a, int b, int c, int d) {
        board[a][b] = 0;
        visited[a][b] = 1;
        queue.add(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == c && poll[1] == d) {
                break;
            }
            a = poll[0];
            b = poll[1];

            for (int i = 0; i < 8; i++) {
                int x = a + moves[i * 2];
                int y = b + moves[i * 2 + 1];
                if (x >= 1 && x <= n && y >= 1 && y <= n && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    queue.add(new int[]{x, y});
                    board[x][y] = board[a][b] + 1;
                }
            }
        }
    }
}
