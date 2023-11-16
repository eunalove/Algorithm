
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  Solution{

	static StringBuilder sb=new StringBuilder();
	static int n, ans= -1;
	static int start_x, start_y;
	static int[][] map;
	static int[] dx= {1, 1, -1, -1}; //오른쪽 아래 부터 시계방향으로 돈다.
	static int[] dy= {1, -1, -1, 1};
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int tc=1; tc<T+1; tc++) {

			ans= -1;
			n= Integer.parseInt(br.readLine());
			
			map= new int[n][n];
			visited= new boolean[101];
			
			for(int i=0; i<n; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}


			//가능한 시작 지점에서 스타트
			for(int i=0; i<n-2; i++) { 
				for(int j=1; j<n-1; j++) {
					start_x= i;
					start_y= j;
					visited[map[i][j]]= true;
					dfs(i,j,1,0);
					visited[map[i][j]]= false;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		
		System.out.print(sb);

	}

	 static void dfs(int x, int y, int cntDessert, int d) {
		 if(d > 3) return;
		 
		//1. 계속 같은 방향으로 돌거나
		//1. 방향을 바꿔서 시계방향으로 돌거나
		//2. 벽에 부딪혀서 or 이미 먹은 디저트라서 돌지 못한다.

		 
		 int nx= x+ dx[d%4];
		 int ny= y+ dy[d%4];
		 
		 
		 if((nx== start_x) && (ny== start_y)) {
			 //출발지에 도착하면 다음으로 가야지
			 if(cntDessert>0) {
				 ans= Math.max(ans, cntDessert);
				 return; //출발지부터 시작하므로 출발지가 아님을 알리기 위해 cntDessert가 0보다 큰 지 확인
			 }
			 
		 }
		 
		 if(nx <0 || ny <0 || nx >=n || ny >=n || visited[map[nx][ny]]) return;
		
		 visited[map[nx][ny]]= true; //방문체크
		 dfs(nx,ny,cntDessert+1,d);
		 dfs(nx,ny,cntDessert+1,d+1);
		 visited[map[nx][ny]]= false; //원상복구
			
			
		
	}
}


