/*
역시 dfs는 하늘에 빌어야 한다
파이프가 두 칸을 차지하므로 뒤에 끝쪽 점만 체크한다
그리고 매개변수 state를 가로,세로,대각선으로 나누어준다
각 dfs케이스에서 인덱스에 벗어나지 않게 if문을 넣어준 다음 dfs를 돌려준다
*/

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
