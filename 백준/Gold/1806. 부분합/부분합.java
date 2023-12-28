/*
투포인터의 가장 중요한 점은 start 이후에 end가 존재해야만 한다는 점이다.
start가 증가하면 end도 항상 증가해야한다.
그리고 인덱스 범위 항상 주의!!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int s= Integer.parseInt(st.nextToken());
		
		int[] arr= new int[n+1];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		
		int end= 0;
		int sum= arr[0];
		int ans= Integer.MAX_VALUE;
		
		
		for(int start=0; start<n; start++) {
			while(end < n && sum < s) {
				sum += arr[++end];
			}
			
			if(end == n) break;

			ans= ans> end- start +1 ? end- start+1: ans;
			sum-= arr[start];
				
			}
		
		if(ans== Integer.MAX_VALUE) System.out.print(0);
		else System.out.print(ans);
		
		
	}

}