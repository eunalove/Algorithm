import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] tri) {
        if(tri == null || tri.length == 0) return 0;

        // 동적 프로그래밍 배열 초기화
        long[][] dp = new long[tri.length][];
        for (int i = 0; i < tri.length; i++) {
            dp[i] = new long[tri[i].length];
        }

        // 시작 위치 초기화
        dp[0][0] = tri[0][0];

        // 삼각형 내려가면서 최댓값 계산
        for (int i = 1; i < tri.length; i++) {
            for (int j = 0; j < tri[i].length; j++) {
                if (j == 0) {
                    // 왼쪽 끝일 때
                    dp[i][j] = dp[i-1][j] + tri[i][j];
                } else if (j == tri[i].length - 1) {
                    // 오른쪽 끝일 때
                    dp[i][j] = dp[i-1][j-1] + tri[i][j];
                } else {
                    // 중간 위치일 때
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
                }
            }
        }

        // 마지막 행에서 최대값 찾기
        long answer = 0;
        for (int i = 0; i < dp[tri.length-1].length; i++) {
            answer = Math.max(answer, dp[tri.length-1][i]);
        }

        return (int)answer;
    }
}
