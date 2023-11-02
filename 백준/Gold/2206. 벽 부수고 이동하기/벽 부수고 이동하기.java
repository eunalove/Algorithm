import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		
		int x;
		int y;
		int broken;
		
		public Node(int x, int y, int broken) {
			super();
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
		
	}

	static int n,m,ans= Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] dist;
	static int[] dx= {-1, 1, 0 ,0};
	static int[] dy= {0, 0, -1, 1}; 

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());

		map= new int[n][m];
		dist= new int[n][m][2];
		
		for(int i=0; i<n; i++) {
			String str= br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]= str.charAt(j)- '0';
			}
		}
		
		//벽 뿌수지 않은 상태로 전체 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				dist[i][j][0]= dist[i][j][1]= -1;
			}
		}
		
		dist[0][0][0]= dist[0][0][1] = 1;
		ans= bfs();
		System.out.println(ans);
		
		
		
	}

	static int bfs() {

		Queue<Node> queue= new ArrayDeque<Node>();

		queue.offer(new Node(0, 0, 0));
		
		while(!queue.isEmpty()) {

			Node node= queue.poll();
			
			if(node.x== n-1 && node.y== m-1) return dist[node.x][node.y][node.broken];

			int nextdist= dist[node.x][node.y][node.broken]+1;
			
			for(int i=0; i<4; i++) {

				int nx= node.x+ dx[i];
				int ny= node.y+ dy[i];

				if(nx <0 || ny<0 || nx>= n || ny>= m) continue;

				if(map[nx][ny] == 0 && dist[nx][ny][node.broken]== -1) { //벽이 아니고 아직 간 적이 없다
					dist[nx][ny][node.broken] = nextdist; //그럼 그냥 지나갑니다
					queue.offer(new Node(nx, ny, node.broken));
				}
				
				//벽을 부순 경우
				if(node.broken== 0 && map[nx][ny] == 1) { //벽이고 아직 부순적이 없다
					dist[nx][ny][1]= nextdist;
					queue.offer(new Node(nx, ny, 1));
				}
				
				
			}
		}
		return -1;

	}

}