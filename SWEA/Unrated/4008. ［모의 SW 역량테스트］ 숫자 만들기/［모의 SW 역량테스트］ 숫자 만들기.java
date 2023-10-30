import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, max= Integer.MIN_VALUE, min= Integer.MAX_VALUE, ans= -1;
	static int[] arr, oper;
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		StringTokenizer st= null;

		for(int t=1; t<tc+1; t++) {

			ans= -1;
			min= Integer.MAX_VALUE;
			max= Integer.MIN_VALUE;
			
			n= Integer.parseInt(br.readLine());
			oper= new int[4];

			arr= new int[n];

			st= new StringTokenizer(br.readLine());

			for(int i=0; i<4; i++) {
				oper[i]= Integer.parseInt(st.nextToken());
			}

			st= new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(arr[0], 1);
			ans= max -min;
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);

	}

	static void dfs(int param, int L) { //계속 합산되는 숫자, 깊이
		//3 5 3 7 9
		// + + - /
		
		if(L == n) {
			min= Math.min(min, param);
			max= Math.max(max, param);
		}

		for(int i=0; i<4; i++) {
			if(oper[i]>0) {
				oper[i]-=1;
				switch (i){
				
				case 0: dfs(param +arr[L], L+1);
				break;
					
				case 1:dfs(param -arr[L], L+1);
				break;
				
				case 2:dfs(param *arr[L], L+1);
				break;
				
				case 3:dfs(param /arr[L], L+1);
				break;
				
				}
				oper[i]+=1;
				

			}
			
		}


	}

}