/*
딱 봐도 어 이건 dfs로 풀면 안될거같은 느낌이 왔다
점화식을 찾아서 dp문제로 풀어보자
입력에서 계단의 갯수가 300이하의 자연수인데,
처음에 초기값을 dp[2][1]= map[2];
이런식으로 설정해서 96%에서 인덱스 오류가 떴다.
계단의 갯수가 1인 경우를 생각하지 못했다
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		int[] map= new int[n+1];
		for(int i=1; i<=n; i++) {
			map[i]= Integer.parseInt(br.readLine());
		}
		
		int[][] dp= new int[n+1][3];
		int ans= 0;
		
		//점화식을 세우자
		//dp[i][j]는 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때
		//점수 합의 최댓값임
		
		//dp[k][1] = max(dp[k-2][1], dp[k-2][2])+ S[k]
		//dp[k][2] = dp[k-1][1]+ S[k]
		
		dp[1][1]= map[1];
		dp[1][2]= 0;
		
		for(int i=2; i<=n; i++) {
			dp[i][1]= Math.max(dp[i-2][1], dp[i-2][2])+ map[i];
			dp[i][2]= dp[i-1][1]+ map[i];
		}
		
		
		ans= Math.max(dp[n][1], dp[n][2]);
		System.out.print(ans);
		
		
	}

}