
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb= new StringBuilder();
	static int n, ans = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<int[]> holeList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc < T + 1; tc++) {
			
		n = Integer.parseInt(br.readLine().trim());
			map = new int[n][n];
			holeList = new ArrayList<int[]>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (5 < map[i][j] && map[i][j] < 11)
						holeList.add(new int[] { i, j, map[i][j]});

				}
			}

			// 시작점, 진행방향 임의로 정하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0) { // 0이면 일단 출발
						for (int d = 0; d < 4; d++) { // 4가지 방향으로 가본다, 상하좌우
							simul(i, j, d);
							
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		ans=0;	
			
		}
		
		System.out.print(sb);
	}

	static void simul(int x, int y, int d) { // 0,0 0상

		int start_x = x;
		int start_y = y;

		int cnt = 0;

		int nx;
		int ny;
		while (true) {
			// 쭉 가기

			nx = x + dx[d];
			ny = y + dy[d];

			// 만약 벽에 부딪힌 경우 점수만 높이고 다음으로
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) {

				if (d == 0) { // 위로 가다 만났다

					d = 1;

				} else if (d == 1) { // 아래로 가다 만났다

					d = 0;
				} else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 3;

				} else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 2;

				}

				cnt += 1;
				x = nx;
				y = ny;
				continue;
			}

			// 블랙홀 들어가거나 원래 위치로 돌아오면 끝내기
			if (map[nx][ny] == -1 || (nx == start_x && ny == start_y)) {

				ans = Math.max(ans, cnt);
				return;
			}

			// 삼각형 만나면 튕기고 점수 올리기
			if (map[nx][ny] == 1) { // 삼각형 1인 경우
				cnt += 1;

				if (d == 0) { // 위로 가다 만났다

					d = 1;

				}

				else if (d == 1) { // 아래로 가다 만났다

					d = 3;
				}

				else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 0;

				}

				else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 2;

				}

			}

			// -------------------------------------------------------------
			if (map[nx][ny] == 2) { // 삼각형 2인 경우
				cnt += 1;

				if (d == 0) { // 위로 가다 만났다

					d = 3;

				}

				else if (d == 1) { // 아래로 가다 만났다

					d = 0;
				}

				else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 1;

				}

				else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 2;

				}
			}

			// -------------------------------------------------------------

			if (map[nx][ny] == 3) { // 삼각형 3인 경우
				cnt += 1;

				if (d == 0) { // 위로 가다 만났다

					d = 2;

				}

				else if (d == 1) { // 아래로 가다 만났다

					d = 0;
				}

				else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 3;

				}

				else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 1;

				}
			}

			// -------------------------------------------------------------
			if (map[nx][ny] == 4) { // 삼각형 4인 경우
				cnt += 1;

				if (d == 0) { // 위로 가다 만났다

					d = 1;

				}

				else if (d == 1) { // 아래로 가다 만났다

					d = 2;
				}

				else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 3;

				}

				else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 0;

				}
			}

			// -------------------------------------------------------------
			if (map[nx][ny] == 5) { // 삼각형 5인 경우
				cnt += 1;

				if (d == 0) { // 위로 가다 만났다

					d = 1;

				}

				else if (d == 1) { // 아래로 가다 만났다

					d = 0;
				}

				else if (d == 2) { // 왼쪽으로 가다 만났다.

					d = 3;

				}

				else if (d == 3) { // 오른쪽으로 가다 만났다.

					d = 2;

				}
			}

			if (5 < map[nx][ny] && map[nx][ny] < 11) { // 웜홀에 걸렸을 때


					for (int i = 0; i < holeList.size(); i++) {
						if (holeList.get(i)[0] != nx || holeList.get(i)[1] != ny) { // 내가 있는 곳이 아니라면
							if (map[nx][ny] == holeList.get(i)[2]) { // 같은 웜홀이라면
								nx = holeList.get(i)[0]; // 현재 위치를 바꾸고
								ny = holeList.get(i)[1];
								break;
								
							}
						
					}
				}

			}
			// 다음 whlie문을 돌기 위해 nx,ny를 현재값으로 바꿔줌
			x = nx;
			y = ny;
		}

	}

}
