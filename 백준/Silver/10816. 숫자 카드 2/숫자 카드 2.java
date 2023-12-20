/*
Map을 쓸수도 있고 아님 이분탐색을 쓸수도 있음
이분탐색을 쓰면 같은 숫자의 가장 뒷순서인 upper에서 가장 앞순서인 lower을 뺀다
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		StringBuilder sb= new StringBuilder();
		
		int n= Integer.parseInt(br.readLine());
		int[] arrN= new int[n];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrN[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		int m= Integer.parseInt(br.readLine());
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int target= Integer.parseInt(st.nextToken());
			sb.append(upper(arrN, target) - lower(arrN, target)).append(" ");
		}
		
		
		
		System.out.print(sb);
		
		
		
	}
	

	 static int lower(int[] arrN, int target) {
		 
		 int low= 0;
		 int high= arrN.length;
		 int mid= 0;
		 
		 while(low < high) {
			 
			 mid= (low+high)/2;
			 
			 if(arrN[mid] >= target) {
				 high= mid;
				 
			 }else 
				 
				 low= mid+1;
		 }
		 
		 return low;
	}

	 static int upper(int[] arrN, int target) {
		 
		 int low= 0;
		 int high= arrN.length;
		 int mid;
		 
		 while(low < high) {
			 
			 mid= (low+high)/2;
			 
			 if(arrN[mid] > target) {
				 high= mid;
				 
			 }else 
				 
				 low= mid+1;
		 }
		 
		 return low;
		 
	}

}