import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, t;
	static int gram_x, gram_y;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {

		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gram_x = i;
					gram_y = j;
				}

			}
		}

		// 그럼 그냥 하던대로 bfs로 최단거리 구하는거랑
		// 검을 가지러 간 다음 가는 최단 거리
		// 이 두개를 구해서 값이 더 작은걸로 하면 되자나

		int min = bfs(); // 실패하면 -1리턴
		visited = new boolean[n][m];

		int min2 = gram_bfs();// 실패하면 -1리턴
		visited = new boolean[n][m];

		int min3 = -1;

		if (min2 != -1) {

			min3 = end_bfs(gram_x, gram_y, min2); // 실패하면 -1리턴

		}
		


		if (min == -1) {

			if (min3 == -1) {
				System.out.print("Fail");
				System.exit(0);

			} else {

				System.out.print(min3);
				System.exit(0);
			}

		}

		if (min3 == -1) {

			if (min == -1) {
				System.out.print("Fail");
				System.exit(0);
			} else {
				System.out.print(min);
				System.exit(0);
			}

		}

		System.out.print(Math.min(min, min3));

	}

	private static int bfs() {

		Queue<Node> queue = new ArrayDeque<Node>();

		visited[0][0] = true;
		queue.offer(new Node(0, 0, 0));

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			if (node.x == n - 1 && node.y == m - 1) {
				if (node.cnt > t) {
					return -1;
				} else {
					return node.cnt;
				}
			}

			for (int i = 0; i < 4; i++) {

				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1 || map[nx][ny] == 2)
					continue;

				if (!visited[nx][ny]) {

					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, node.cnt + 1));

				}
			}
		}

		return -1;
	}

	private static int gram_bfs() {
		Queue<Node> queue = new ArrayDeque<Node>();

		visited[0][0] = true;
		queue.offer(new Node(0, 0, 0));

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			if (node.x == gram_x && node.y == gram_y) {
				if (node.cnt > t) {
					return -1;
				} else {
					return node.cnt;
				}
			}

			for (int i = 0; i < 4; i++) {

				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1)
					continue;

				if (!visited[nx][ny]) {

					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, node.cnt + 1));

				}
			}
		}

		return -1;
	}

	private static int end_bfs(int x, int y, int cnt) {

		Queue<Node> queue = new ArrayDeque<Node>();

		visited[x][y] = true;
		queue.offer(new Node(x, y, cnt));

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			if (node.x == n - 1 && node.y == m - 1) {
				if (node.cnt > t) {
					return -1;
				} else {
					return node.cnt;
				}
			}

			for (int i = 0; i < 4; i++) {

				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (!visited[nx][ny]) {

					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny, node.cnt + 1));

				}
			}
		}

		return -1;
	}
}