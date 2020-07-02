package dynamicprograming;

public class EggDrop {
    public static void main(String[] args) {
        System.out.println(superEggDrop(5, 10000));
    }

    public static int superEggDrop(int K, int N) {
        Integer[][] dp = new Integer[N + 1][K + 1];
        return eggDrop(K, N, dp);
    }

    public static int eggDrop(int K, int N, Integer[][] dp) {
        if (K == 1) return N;
        if (N == 0) return 0;
        if (dp[N][K] != null) return dp[N][K];

        Integer res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(eggDrop(K - 1, i - 1, dp), eggDrop(K, N - i, dp)) + 1);
        }
        dp[N][K] = res;
        return res;
    }
}
