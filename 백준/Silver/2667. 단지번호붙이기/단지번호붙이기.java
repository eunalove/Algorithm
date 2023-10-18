import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;

public class Main {
	
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		
		map= new int[n][n];
		visited= new boolean[n][n];
		list= new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			String str= br.readLine();
			for(int j=0; j<n; j++) {
				
				map[i][j]= (str.charAt(j)=='0'? 0:1);
				
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]== 1 && !visited[i][j]) {
				int value= bfs(i,j);
				list.add(value);
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		
		for(int x: list) {
			sb.append(x).append("\n");
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
				
				if(nx <0 || nx>= n || ny<0 || ny>= n || map[nx][ny]==0) continue;
				
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