/*
이때까지와 달리 for()문으로 상하좌우를 탐색하지 말고
4개의 if문으로 상하좌우를 탐색함
boolean visited를 사용하지 않고 map에서 너비를 표시함
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int m= Integer.parseInt(st.nextToken());
		int n= Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		boolean flag= false;
		
		Queue<int[]> queue= new ArrayDeque<int[]>();
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {

				map[i][j]= Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0) {
					flag= true;
				}else if(map[i][j] == 1) {
					queue.offer(new int[] {i,j});
					
				}
			}
		}
		
		if(!flag) { //토마토가 모두 익은 경우
			System.out.print(0);
		}else {

		while(!queue.isEmpty()) {

			int[] node= queue.poll();

			if(node[0]>0 && map[node[0]-1][node[1]] == 0) { //상

				map[node[0]-1][node[1]]= map[node[0]][node[1]]+1;
				queue.add(new int[]{node[0]-1, node[1]});

			}

			if(node[0]<n-1 && map[node[0]+1][node[1]] == 0) { //하

				map[node[0]+1][node[1]] =map[node[0]][node[1]]+1;
				queue.add(new int[]{node[0]+1, node[1]});

			}

			if(node[1]>0 && map[node[0]][node[1]-1] == 0) { //좌

				map[node[0]][node[1]-1] =map[node[0]][node[1]]+1;
				queue.add(new int[]{node[0], node[1]-1});

			}
			

			if(node[1]<m-1 && map[node[0]][node[1]+1] == 0) { //우

				map[node[0]][node[1]+1] =map[node[0]][node[1]]+1;
				queue.add(new int[]{node[0], node[1]+1});

			} 

		}
		
		int ans= -1;
		int check= 0;
		
		Loop: for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					System.out.print(-1);
					check= -1;
					break Loop;
				}
				ans= Math.max(map[i][j], ans);

			}
		}
		
		if(check== 0) { //모든 토마토가 익지는 못하는 상황
			System.out.print(ans-1);
		}

		}
	}

}