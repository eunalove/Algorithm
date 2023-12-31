import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[100001];		
		int ans = 0;
		int start = 0;
		
		for (int end = 0; end < n; end++) {
			count[arr[end]]++;
			
			while (count[arr[end]] > k) {
				count[arr[start]]--;
				start++;
			}
			
			ans = Math.max(ans, end - start + 1);
		}
		
		System.out.print(ans);
	}
}