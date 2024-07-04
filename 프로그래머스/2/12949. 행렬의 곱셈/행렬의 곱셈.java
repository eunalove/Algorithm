class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int k = arr1[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int l = 0; l < k; l++) {
                    sum += arr1[i][l] * arr2[l][j];
                }
                ans[i][j] = sum;
            }
        }

        return ans;
    }
}
