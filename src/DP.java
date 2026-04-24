import java.util.*;

public class DP {

    static int[] dp;

    static int fib(int n) {
        if (dp[n] != -1) return dp[n];

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Base cases
        dp[0] = 0;
        if (n >= 1) dp[1] = 1;

        int result = fib(n);

        System.out.println("Fibonacci of " + n + " = " + result);

        System.out.println("DP Array:");
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}