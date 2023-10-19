/*
for(int i=0; i<4; i++){

} 

if(x-1 >= 0 && !visited[map[x-1][y]) 와 같은 if문 4개

두 코드의 시간복잡도 차이가 많이 날까?
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, ans= Integer.MIN_VALUE;
	static char map[][];
	static boolean visited[];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		 n= Integer.parseInt(st.nextToken());
		 m= Integer.parseInt(st.nextToken());
		
		map= new char[n][m];
		visited= new boolean[100];
		
		for(int i=0; i<n; i++) {
			String str= br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited[map[0][0]]= true;
		dfs(0,0,1);
		
		System.out.println(ans);
	}

	 static void dfs(int r, int c, int cnt) {
		 
		 ans= Math.max(ans, cnt);
		 
		 if(r-1>=0 && visited[map[r-1][c]] == false){
				visited[map[r-1][c]] = true;
				dfs(r-1, c, cnt+1);
				visited[map[r-1][c]] = false;
			}
			
			if(r+1<n && visited[map[r+1][c]] == false){
				visited[map[r+1][c]] = true;
				dfs(r+1, c, cnt+1);
				visited[map[r+1][c]] = false;
			}
			
			if(c-1>=0 && visited[map[r][c-1]] == false){
				visited[map[r][c-1]] = true;
				dfs(r, c-1, cnt+1);
				visited[map[r][c-1]] = false;
			}
			
			if(c+1<m && visited[map[r][c+1]] == false){
				visited[map[r][c+1]] = true;
				dfs(r, c+1, cnt+1);
				visited[map[r][c+1]] = false;
			}
		 
	}
}