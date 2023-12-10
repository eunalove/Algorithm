/*
이전의 2xn타일링 문제에서 2x2블록이 늘어났다
2x1블록이 가능했던 상황에서 2x2블록도 쌓을 수 있기 때문에 dp[i-2]에 2를 곱해주었다.
*/
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n= sc.nextInt();
	
		
		if(n==1) {
			System.out.print(1);
		}else {
			
			int[] dp= new int[n+1];
			
			dp[1]= 1;
			dp[2]= 3;
			
			for(int i=3; i<=n; i++) {
				
				dp[i]= dp[i-1]%10007+dp[i-2]*2%10007;
				dp[i] %= 10007;
				
				
			}
			
			System.out.print(dp[n]);
			
		}
		
		
	}

}