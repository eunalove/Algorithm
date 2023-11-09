import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, cnt_white, cnt_blue;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		n= Integer.parseInt(br.readLine());
		map= new int[n][n];
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		dfs(0,0,n);
		System.out.println(cnt_white);
		System.out.println(cnt_blue);


	}

	private static void dfs(int x, int y, int n) {
		
		if(n == 0) {
			return;
		}
		
		int zero =0;
		int one = 0;
		
		for(int i=x ; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(map[i][j] == 0) {
					zero+=1;
				}else {
					one+=1;
				}
			}
		}
		
		if(n*n == zero) {
			cnt_white+=1;
			return;
		}
		
		if(n*n == one) {
			cnt_blue+=1;
			return;
		}
		
		int half= n/2; 
		dfs(x, y,half);//8 4
		dfs(x, y+half, half);//4
		dfs(x+half, y, half);
		dfs(x+half, y+half, half);
		
				
		
	}

}