
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int ans;
	static ArrayList<Integer> list[];
	static boolean visited[];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < TC + 1; tc++) {

			st= new StringTokenizer(br.readLine());
			
			int n= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
		
			list= new ArrayList[n+1];
			visited= new boolean[n+1];
		
			for(int i=1; i<n+1; i++) { //초기화
				list[i]= new ArrayList<>();
			}
		
			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
				
			}
			
			ans= 0;
		
			for(int i=1; i<n+1; i++) {
				if(!visited[i]) {
				ans+=1; 
				dfs(i);
			}
			}
		
		System.out.printf("#%d %d%n",tc,ans);
		
	}

}



	 static void dfs(int v) {
		 
		 for(int cnt: list[v]) {
		 
			 if(!visited[cnt]) {
				 visited[cnt]= true;
				 dfs(cnt);
			 }
		 
		 }
		 
	 }
		
	}



