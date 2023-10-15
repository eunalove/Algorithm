
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        map = new int[n][n];
        dp = new long[n][n][3]; // 3가지 상태에 대한 메모이제이션 배열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1); // dp 배열 초기화
            }
        }

        long res = dfs(0, 1, 0); // 시작 위치에서 가로 상태로 시작
        System.out.println(res);
    }

    static long dfs(int x, int y, int state) {
        if (x == n - 1 && y == n - 1) {
            return 1; // 목표 지점에 도달하면 1을 반환
        }

        if (dp[x][y][state] != -1) {
            return dp[x][y][state];
        }

        long ways = 0;

        if (state == 0) { // 가로 방향일 때
            if (y + 1 < n && map[x][y + 1] == 0) {
                ways += dfs(x, y + 1, 0); // 가로로 계속 진행
            }
            if (x + 1 < n && y + 1 < n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                ways += dfs(x + 1, y + 1, 2); // 대각선으로 전환
            }
        } else if (state == 1) { // 세로 방향일 때
            if (x + 1 < n && map[x + 1][y] == 0) {
                ways += dfs(x + 1, y, 1); // 세로로 계속 진행
            }
            if (x + 1 < n && y + 1 < n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                ways += dfs(x + 1, y + 1, 2); // 대각선으로 전환
            }
        } else if (state == 2) { // 대각선 방향일 때
            if (y + 1 < n && map[x][y + 1] == 0) {
                ways += dfs(x, y + 1, 0); // 가로로 전환
            }
            if (x + 1 < n && map[x + 1][y] == 0) {
                ways += dfs(x + 1, y, 1); // 세로로 전환
            }
            if (x + 1 < n && y + 1 < n && map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
                ways += dfs(x + 1, y + 1, 2); // 대각선으로 계속 진행
            }
        }

        return dp[x][y][state] = ways;
    }
}
