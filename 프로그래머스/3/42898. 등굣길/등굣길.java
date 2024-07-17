class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][m];
        
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < m; j++) {
            if (dp[0][j] == -1) break;
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;  // 물웅덩이는 경로가 없으므로 0으로 설정
                } else {
                    if (dp[i - 1][j] != -1) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    if (dp[i][j - 1] != -1) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
}
