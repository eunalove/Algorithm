/*
어차피 값의 범위가 100이므로 미리 dp를 만들어놓고 시작하기
이번에도 int가 아니고 long임 잘 확인하자!!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		long[] dp= new long[101];
		
		dp[1]= 1;
		dp[2]= 1;
		dp[3]= 1;
		dp[4]= 2;
		dp[5]= 2;
		dp[6]= 3;
		dp[7]= 4;
		dp[8]= 5;
		dp[9]= 7;
		dp[10]= 9;
		
		for(int i=11; i<=100; i++) {
			dp[i]= dp[i-1]+dp[i-5];
		}
		
		for(int t=0; t<T; t++) {
			
			int n= Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
			
			
		}
		
		System.out.print(sb);
		
		
	}

}