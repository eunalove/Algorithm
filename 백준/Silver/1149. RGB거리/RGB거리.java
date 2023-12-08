/*
dp의 가장 중요한 점은 점화식을 찾는 것이다.
이번 문제는 직전 집과 현재 집의 색깔만 다르면 되는 문제였다.
이차원 배열 dp문제!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		int n= Integer.parseInt(br.readLine());
		
		int[][] dp= new int[n+1][4];
		int[][] map= new int[n+1][4];
		
		for(int i=1; i<=n; i++) {
			st= new StringTokenizer(br.readLine());
			
			map[i][1]= Integer.parseInt(st.nextToken());
			map[i][2]= Integer.parseInt(st.nextToken());
			map[i][3]= Integer.parseInt(st.nextToken()); 
			
		}
		
		dp[1][1]= map[1][1];
		dp[1][2]= map[1][2];
		dp[1][3]= map[1][3];
		
		for(int i=2; i<=n; i++) {
			dp[i][1]= Math.min(dp[i-1][2], dp[i-1][3])+ map[i][1];
			dp[i][2]= Math.min(dp[i-1][1], dp[i-1][3])+ map[i][2];
			dp[i][3]= Math.min(dp[i-1][1], dp[i-1][2])+ map[i][3];
			
		}
		
		int ans= Integer.MAX_VALUE;
		
		
		  for(int i=1; i<=3; i++) {
			  ans = Math.min(ans, dp[n][i]); 
			  }
		 
		System.out.println(ans);
		
		
		
	}

}