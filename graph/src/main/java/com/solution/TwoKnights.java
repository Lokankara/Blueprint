package com.solution;

import java.util.Scanner;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String red = scanner.next();
        String green = scanner.next();
        int movesRequired = minMoves(red, green);
        System.out.println(movesRequired);
    }

    private static int minMoves(String red, String green) {
        int redX = red.charAt(0) - 'a';
        int redY = red.charAt(1) - '1';
        int greenX = green.charAt(0) - 'a';
        int greenY = green.charAt(1) - '1';

        int dx = Math.abs(redX - greenX);
        int dy = Math.abs(redY - greenY);

        return (dx + dy) % 2 == 0
                ? Math.max(dx, dy) / 2
                : -1;
    }
}