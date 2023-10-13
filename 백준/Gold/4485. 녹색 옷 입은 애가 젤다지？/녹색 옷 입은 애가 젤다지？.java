
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int cnt;
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx= {-1, 1, 0, 0}; //상하좌우
	static int[] dy= {0, 0, -1, 1};
	
	static class Node implements Comparable<Node>{
		
		int x; int y; int rupee;

		public Node(int x, int y, int rupee) {
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Node o) {
			return (this.rupee- o.rupee);
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {

			cnt+=1;
			
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				System.exit(0);
			}

			map = new int[n][n];
			visited= new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			
			System.out.printf("Problem %d: %d%n",cnt,bfs());

		}

	}

	 static int bfs() {
		 
		 PriorityQueue<Node> queue= new PriorityQueue();
		 queue.add(new Node(0, 0, map[0][0]));
		 
		 while(!queue.isEmpty()) {
		 
		 Node node= queue.poll();
		 
		 if(node.x == n-1 && node.y == n-1) {
			 return node.rupee;
		 }
		 
		 visited[node.x][node.y]= true;
		 
		 for(int i=0; i<4; i++) {
		 
		 int nx= node.x+ dx[i];
		 int ny= node.y+ dy[i];
		 
		 if(nx <0 || nx >= n || ny<0 || ny>= n) continue;
		 
		 if(!visited[nx][ny]) {
		 
			 queue.add(new Node(nx, ny, node.rupee+ map[nx][ny]));
			 
		 
		 }
		 
		 }
		 
		 
		 
		 
		 }
		return -1;
		
	}

}
