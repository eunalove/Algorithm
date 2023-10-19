import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,k;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		
		map= new int[n][m];
		visited= new boolean[n][m];
		list= new ArrayList<Integer>();
	
		for(int i=0; i<k; i++) {
			st= new StringTokenizer(br.readLine());
			int y1= Integer.parseInt(st.nextToken());
			int x1= Integer.parseInt(st.nextToken());
			
			int y2= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			
			for(int j= x1; j<x2; j++) {
				for(int l= y1; l<y2; l++) {
					map[j][l] = 1;
				}
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]== 0 && !visited[i][j]) {
				int value= bfs(i,j);
				list.add(value);
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		
		for(int x: list) {
			sb.append(x).append(" ");
		}
		
		System.out.print(sb);
	}

	private static int bfs(int x, int y) {
	
		Queue<int[]> queue= new ArrayDeque<int[]>();
		queue.offer(new int[] {x,y});
		visited[x][y] =true;
		
		int ans= 1;
		
		while(!queue.isEmpty()) {
			
			int[] node= queue.poll();
			
			for(int i=0; i<4; i++) {
				
				int nx= node[0]+ dx[i];
				int ny= node[1]+ dy[i];
				
				if(nx <0 || nx>= n || ny<0 || ny>= m || map[nx][ny]==1) continue;
				
				if(!visited[nx][ny]) {
					
					visited[nx][ny] = true;
					queue.offer(new int[] {nx,ny});
					ans+=1;
				}
			}
			
		}
		
		return ans;
	}
}