import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] map;
	static int half;
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());

		map= new char[n][n];

		for(int i=0; i<n; i++) {
			String str= br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= str.charAt(j);
			}
		}

		dfs(0,0,n);
		System.out.print(sb);
	}

	static void dfs(int x, int y, int n) {

		int cntZero = 0;
		int cntOne = 0;

		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(map[i][j]=='0') {
					cntZero+=1;
				}else {
					cntOne+=1;
				}
			}
		}

		if(cntZero == n*n) {
			sb.append(0);
			return;
		}else if(cntOne == n*n) {
			sb.append(1);
			return;
		}else {
			sb.append("(");
		}
		

		int half= n/2;
		
		
		dfs(x, y, half);
		dfs(x, y+half, half);
		dfs(x+half, y, half);
		dfs(x+half, y+half, half);
		sb.append(")");

	}

}