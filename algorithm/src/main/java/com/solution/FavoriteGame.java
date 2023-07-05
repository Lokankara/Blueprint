package com.solution;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FavoriteGame {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> spent = getSpentTime(scanner);

        int favoriteGame = spent.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        writer.println(favoriteGame);
        writer.flush();
    }

    private static Map<Integer, Integer> getSpentTime(Scanner scanner) {
        Map<Integer, Integer> spent = new HashMap<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int game = scanner.nextInt();
            int time = scanner.nextInt();
            spent.put(game, spent.containsKey(game)
                    ? spent.get(game) + time
                    : time);
        }
        return spent;
    }
}
