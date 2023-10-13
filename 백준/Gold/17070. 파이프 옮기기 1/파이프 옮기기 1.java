
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		dfs(1, 0, 1);

		System.out.println(ans);

	}

	static void dfs(int state, int x, int y) {

		if (x == n - 1 && y == n - 1) {
			ans += 1;
			return;
		}

		if (x >= n || y >= n)
			return;

		if (state == 1) { // 가로로 놓여져 있는 경우
			// 계속 가로로 놓는다.
			if (y < n - 1) {
				if (map[x][y + 1] == 0) {
					dfs(1, x, y + 1);
				}
			}

				if (x < n - 1 && y < n - 1) {
					if (map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
						// 대각선으로 놓는다.
						dfs(3, x + 1, y + 1);
					}
				}
			
		}
			if (state == 2) { // 세로로 놓여져 있는 경우
				// 계속 세로로 놓는다.
				if (x < n - 1) {
					if (map[x + 1][y] == 0) {

						dfs(2, x + 1, y);
					}
				}

				if (x < n - 1 && y < n - 1) {
					if (map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
						// 대각선으로 놓는다.
						dfs(3, x + 1, y + 1);
					}
				}

			}
				if (state == 3) { // 대각선으로 놓여져 있는 경우
					// 가로로 놓는다.

					if (y < n - 1) {
						if (map[x][y + 1] == 0) {
							dfs(1, x, y + 1);
						}
					}

					// 세로로 놓는다.
					if (x < n - 1) {
						if (map[x + 1][y] == 0) {
							dfs(2, x + 1, y);
						}
					}

					if (x < n - 1 && y < n - 1) {
						if (map[x + 1][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0) {
							dfs(3, x + 1, y + 1);
						}
					}
				}

			}
		
	}
