import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n= Integer.parseInt(br.readLine());
		int m= Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer>[] list= new ArrayList[n+1];
		
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
		
		ArrayList<Integer> freind= new ArrayList<Integer>();
		boolean[] visited= new boolean[n+1];
		
		for(int x: list[1]) {//상근이의 친구들을 넣음
			freind.add(x);
			visited[x]= true;
		}
		
		
		for(int x: freind) {// 2 3
			
			for(int y: list[x])
				visited[y]= true;
				
		}
		visited[1]= false; //상근이 자기자신은 빼준다
		
		int ans= 0;
		
		for(boolean x: visited) 
			if(x) ans++;
			
		System.out.print(ans);
		
	}
	

}