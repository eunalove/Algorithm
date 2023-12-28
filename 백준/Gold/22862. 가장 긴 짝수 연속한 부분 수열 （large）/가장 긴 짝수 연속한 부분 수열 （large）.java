import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		
		int[] arr= new int[n];
		
		st= new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}

		
		int ans= Integer.MIN_VALUE;
		int cnt= 0;
		int end= 0;
		int start= 0;
		
		 while (end < n) {
	            if (arr[end] % 2 == 1) {
	                cnt++;
	            }

	            if (cnt > k) {
	                while (arr[start] % 2 == 0) {
	                    start++;
	                }
	                start++;
	                cnt--;
	            }

	            ans = Math.max(ans, end - start + 1- cnt);
	            end++;
	        }

		
		System.out.print(ans);
		
		
	}

}