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
		 
		 //2 3 3 3 5, 4를 입력하면 5가 나와야함
		 
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
		 
		 if(high == n) continue;
		 
		 ans= Math.min(ans, arr[high]- arr[i]);
		 
		 if(ans == m) break;
		 
	}
	 }

}