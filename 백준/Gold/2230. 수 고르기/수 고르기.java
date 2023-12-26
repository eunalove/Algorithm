/*
이분탐색을 이용함
lower를 이용해서 특정 값보다 같거나 직후로 큰 값을 구함
for문으로 i를 모두 돌면서 lower로 arr[mid]- arr[i]가 특정 값보다 작은지 체크함
O(10만)*O(log10만)하면 대략 160만이 나온다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int n, m, ans= Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		arr= new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		lowerBound();
		
		System.out.print(ans);
	}

	 static void lowerBound() {
		 
		 int low= 0;
		 int high= arr.length;
		 int mid= 0;
		 
		 for(int i=0; i<n; i++) {
			 
			 low= i;
			 high= n;
			 
		 while(low < high) {
			 
			 mid= (low+high)/2;
			 
			 if(arr[mid]- arr[i] < m) low= mid+1;
			 else high= mid;
		 }
             
         //하지 않으면 런타임 오류남
         if(high== n) continue;
		 
		 ans= Math.min(ans, arr[high]- arr[i]);
		 
		 
	}
	 }

}