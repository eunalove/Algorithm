import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, ans= Integer.MIN_VALUE;
	static int map[][];
	static boolean visited[];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		 n= Integer.parseInt(st.nextToken());
		 m= Integer.parseInt(st.nextToken());
		
		map= new int[n][m];
		visited= new boolean[43];
		
		for(int i=0; i<n; i++) {
			String str= br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)- '0';
			}
		}
		
		visited[map[0][0]]= true;
		dfs(0,0,0);
		System.out.print(ans+1);
		
	}

	 static void dfs(int x, int y, int cnt) {
		 
		 ans= Math.max(ans, cnt);
		 
		 for(int i=0; i<dx.length; i++) {
			 
			 int nx= x+ dx[i];
			 int ny= y+ dy[i];
			 
			 if(nx<0 || nx>= n || ny<0 || ny>= m) continue;
			 
			 if(!visited[map[nx][ny]]) {
				 visited[map[nx][ny]] =true;
				 dfs(nx, ny,cnt+1);
				 visited[map[nx][ny]] =false;
				
				 
			 }
		 }	 
		 
	}
}