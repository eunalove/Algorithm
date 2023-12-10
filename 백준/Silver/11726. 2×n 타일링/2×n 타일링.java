import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int[] dp= new int[n+1];
		
		if(n==1) {
			System.out.print(1);
			
		}else {
			
			//점화식 dp[i]= dp[i-1]+dp[i-2]
			//dp[i-1]은 1X2를 하나 추가한 경우, dp[i-2]는 2X2를 추가한 경우
			
			dp[1]= 1;
			dp[2]= 2;
			
			for(int i=3; i<=n; i++) {
				dp[i]= dp[i-1]%10007+dp[i-2]%10007;
				dp[i] %=10007;
			}
			
			System.out.print(dp[n]);
			
			
		}
		
	}

}