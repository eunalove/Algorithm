import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean[] depth;
	static int score;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		list= new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		while(true) {
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int a1= Integer.parseInt(st.nextToken());
		int a2= Integer.parseInt(st.nextToken());
		
		if(a1==-1 && a2==-1) break;
		
		list[a1].add(a2);
		list[a2].add(a1);
		
		}
		
		int[][] candi= new int[n+1][2];
		//첫번째 인자는 회장 후보의 점수
		//두번째 인자는 회장 후보
		
		for(int i=1; i<=n; i++) {
			visited= new boolean[n+1];
			score= 0;
			bfs(i);
			candi[i][0]= score;
			candi[i][1]= i;
		}
		
		//오름차순 정렬
		Arrays.sort(candi, (c1, c2)->{
			
			if(c1[0]==c2[0]) return c1[1]-c2[1];
			return c1[0]-c2[0];
			
		});
		
//		for(int[] x: candi) {
//			for(int y: x) {
//				System.out.print(y+" ");
//			}
//			System.out.println();
//		}
		
		int num= candi[1][0]; //2
		int cnt= 0; //0
		
		for(int i=1; i<=n; i++) {
			if(num != candi[i][0]) break;
			else cnt++;
		}
		
		StringBuilder sb= new StringBuilder();
		sb.append(num).append(" ").append(cnt).append("\n");
		
		for(int i=1; i<cnt+1; i++) {
			sb.append(candi[i][1]).append(" ");
		}
		
		System.out.print(sb);
		
		
		
		
	}

	private static void bfs(int i) {
		//하나의 x는 모두 같은 깊이임
		//뎁스관리를 해야하기 때문에 bfs로 해보겟음
		
		Queue<int[]> q= new ArrayDeque<int[]>();
		q.add(new int[] {i,0});
		visited[i]= true;
		
		while(!q.isEmpty()){
			
			int[] tmp= q.poll();
			
			int num= tmp[0];
			int sc= tmp[1];
			score= sc;
			
			for(int x: list[num]) {
				if(!visited[x]) {
				q.add(new int[] {x, sc+1});
				visited[x]= true;
				}
			}
		}
		
		
	}

}