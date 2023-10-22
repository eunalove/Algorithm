import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Bias implements Comparable<Bias> {

		int x;
		int y;
		int num;

		public Bias(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(Bias o) {
			return this.num- o.num;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		PriorityQueue<Bias> queue = new PriorityQueue<Bias>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					queue.offer(new Bias(i, j, map[i][j]));
				}
			}

		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		PriorityQueue<Bias> copyQueue= new PriorityQueue<Bias>();
		
		for (int t = 0; t < s; t++) {

			
			if(!copyQueue.isEmpty()) {
				
				queue= new PriorityQueue<Bias>(copyQueue);
			}
			
			copyQueue= new PriorityQueue<Bias>();
			
			while(!queue.isEmpty()) {
				Bias bias = queue.poll();
				
				// 연결된 정점으로 바이러스가 확산됨

				for (int i = 0; i < 4; i++) {

					int nx = bias.x + dx[i];
					int ny = bias.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)continue;

					if (map[nx][ny] == 0) {

						map[nx][ny] = bias.num;
						copyQueue.offer(new Bias(nx, ny, bias.num));

					}
				}
			}
			

		}

	

		System.out.print(map[x - 1][y - 1]);

	}

}