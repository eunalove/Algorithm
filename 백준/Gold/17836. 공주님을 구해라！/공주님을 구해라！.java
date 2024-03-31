import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	
	static class Node{
		int x; int y; int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		int t= Integer.parseInt(st.nextToken());
		
		//map 입력
		map= new int[n][m];
		int gumX=0; int gumY= 0;
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=  Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					gumX= i;
					gumY= j;
				}
			}
		}
		
		//그냥 공주님을 향해 bfs
		int goPrincess= bfs(n-1,m-1);
		
        //검을 향해 bfs
		int goGum= bfs(gumX, gumY);
        
        //검을 얻으면 그냥 공주님한테 바로 가면 됨
		int goPrincessWithGum= goGum+ n-1-gumX + m-1-gumY;
		
		if(goGum == Integer.MAX_VALUE) goPrincessWithGum= Integer.MAX_VALUE;
		
		//두개의 bfs중에서 더 짧은거 선택
		int ans= Math.min(goPrincess, goPrincessWithGum);
		
		//T보다 크다면 Fail, 아니라면 시간 출력
		
		if(ans == Integer.MAX_VALUE || ans> t) System.out.print("Fail");
		else System.out.print(ans);
		
		
	
	}
	
	static int bfs(int endX, int endY) {
		
		//검을 향해 bfs+ 공주님한테 바로 가기
		Queue<Node> q= new ArrayDeque<Node>();
		q.add(new Node(0,0,0));
		
		boolean[][] visited= new boolean[n][m];
		visited[0][0]= true;
		
		
		while(!q.isEmpty()) {
			
			Node node= q.poll();
			
			if(node.x== endX && node.y== endY)
				return node.time;
				
			
			
			for(int i=0; i<4; i++) {
				int nx= node.x+ dx[i];
				int ny= node.y+ dy[i];
				
				if( nx <0 || ny <0 || nx>= n || ny>= m|| visited[nx][ny]|| map[nx][ny]==1) continue;
				
				visited[nx][ny]= true;
				q.add(new Node(nx, ny, node.time+1));
				
				
			}
			
			
		}
		
		return Integer.MAX_VALUE;
		
	}
	
	
	
	
}