package com.solution;

public class Baghdad {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
        int[] min = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        int[] max = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11};
        int[] N = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        int n = 0;
        for (int i = 0; i < 20; i++) {
            n = i + 3;
            int minHonest = 0;
            int maxHonest = 0;
            if (N[i] % 2 == 0) {
                minHonest = (n - 1) / 2;
                maxHonest = n / 2;
            } else {
                maxHonest = minHonest = (n - 1) / 2;
            }

//            if (N[i] % 3 == 0 && N[i] % 2 == 0) {
//                minHonest = (N[i] / 2)-1;
//                maxHonest = N[i] / 2;
//            } else if (N[i] % 3 == 0 && !(N[i] % 2 == 0)) {
//                minHonest = ((N[i])) / 2 -1;
//                maxHonest = (N[i]) / 2;
//            } else if (N[i] % 3 == 1) {
//                minHonest = (N[i]/3)+2;
//                maxHonest = N[i] / 2;
//            } else if (N[i] % 3 == 2) {
//                minHonest = (N[i] - 1) / 2;
//                maxHonest = N[i] / 2;
//            }

//            int minHonest = (N % 2 == 0) ? ((N + 1) / 3) : ((N + 2) / 3);
//            int maxHonest = (N % 2 == 0) ? (N / 2) : (N - 1) / 2;


            if (min[i] != minHonest) {
                System.err.printf("%d: %d %d - %d%n", N[i], min[i], max[i], minHonest);
            }
            if (max[i] != maxHonest) {
                System.err.printf("%d: %d %d - %d%n", N[i], min[i], max[i], maxHonest);
            }
        }
    }
}
