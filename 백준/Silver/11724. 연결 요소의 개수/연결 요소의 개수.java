//항상 dfs로 그래프를 풀다가 bfs로 푸니까 신선했다.

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		list= new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		while(m-->0) { //그래프에 값 넣어줌
			st= new StringTokenizer(br.readLine());
			
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
		}
		
		Queue<Integer> q= new ArrayDeque<Integer>();
		visited= new boolean[n+1];
		int ans= 0;
		
		for(int i=1; i<=n; i++) {
		
		if(visited[i]) continue;
		
		q.offer(i);
		visited[i]= true;
		
		ans++;
		
		while(!q.isEmpty()) {
			
			int v= q.poll();
			
			for(int x: list[v]) {
				
				if(visited[x]) continue;
				q.offer(x);
				visited[x]= true;
			}
			
		}
		
		
		}
		
		System.out.print(ans);

	}

}