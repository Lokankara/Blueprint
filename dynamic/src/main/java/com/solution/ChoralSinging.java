package com.solution;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChoralSinging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println("n = " + n + ", m = " + m);

            boolean canAllSing = canAllSing(n, m);
            if (canAllSing) {
                writer.println("YES");
            } else {
                writer.println("NO");
            }
        }

        writer.flush();
        writer.close();
    }

    private static boolean canAllSing(int n, int m) {
        int a = n;
        int b = m;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        System.out.println(temp);
        }
        return a == 1;
    }
}
