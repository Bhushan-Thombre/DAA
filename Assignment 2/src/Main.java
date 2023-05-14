// Name = Bhushan Thombre
// Division = D
// Batch = D1
// Roll No. = 324021
// Gr No. = 22010801

// Assignment 2
// Implement 0/1 Knapsack using Dynamic Programming

public class Main {

    // Time Complexity = O(n * W)
    // Space Complexity = O(n * W)
    public static int dp(int W, int[] wt, int[] val, int n) {
        int[][] table = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            table[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                }else {
                    table[i][j] = Math.max(table[i - 1][j], val[i - 1] + table[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return table[n][W];
    }

    // Time Complexity = O(2^n)
    // Space Complexity = O(1)
    public static int recursion(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return recursion(W, wt, val, n - 1);
        }else {
            return Math.max(recursion(W, wt, val, n - 1), val[n - 1] + recursion(W - wt[n - 1], wt, val, n - 1));
        }
    }
    public static void main(String[] args) {
        int[] val = { 10, 40, 30, 50 };
        int[] wt = { 5, 4, 6, 3 };
        int W = 10;
        int n = 4;
        System.out.println("Maximum value using recursion");
        System.out.println(recursion(W, wt, val, n));
        System.out.println("Maximum value using dynamic programming");
        System.out.println(dp(W, wt, val, n));
    }
}
