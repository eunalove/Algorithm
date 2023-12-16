/*
그리디 문제는 대부분 뒤에서부터 생각하면 풀린다
이번문제도 뒤에서부터 탐색해서 나보다 작으면 모두 수익임!!
*/
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		StringBuilder sb= new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
		int n= Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		st= new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
		
			arr[i]= Integer.parseInt(st.nextToken());
		
		}
		
		//뒤에서부터 탐색해서 현재 나보다 작으면 그게 다 수익이다.
		int max= Integer.MIN_VALUE;
		long ans= 0;
		
		for(int i=n-1; i>=0; i--) {
			if(arr[i] > max) max= arr[i]; //9
			else ans= ans+max-arr[i];
		}
		
		sb.append(ans).append("\n");
		
		
	}
		
		System.out.print(sb);
	}
}