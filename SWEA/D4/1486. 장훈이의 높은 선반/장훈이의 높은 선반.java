
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n,b, ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < TC + 1; tc++) {
		
			ans = Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			
			 n= Integer.parseInt(st.nextToken()); //점원 숫자
			 b= Integer.parseInt(st.nextToken()); //선반 높이
			
			arr= new int[n];
			
			st= new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		
			dfs(0,0); //부분집합 출발
		
			System.out.printf("#%d %d%n",tc,ans);
		
	}
	}

	private static void dfs(int L, int tot) {
		
		if(L == n) {
			if(tot >= b) {
				ans= Math.min(ans, tot-b);
			}
			return;
		}
		
		
		dfs(L+1, tot); //선택하지 않은 경우
		dfs(L+1, tot+arr[L]); //선택한 경우
		
		
	}
}
