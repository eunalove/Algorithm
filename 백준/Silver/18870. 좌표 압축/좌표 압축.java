import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		StringTokenizer st= new StringTokenizer(br.readLine());
		Set set= new HashSet();
		
		for(int i=0; i<n; i++) {
			int cnt= Integer.parseInt(st.nextToken()); 
			set.add(cnt);
			arr[i]= cnt;
		}
		
		ArrayList<Integer> list= new ArrayList<Integer>(set);
		 // ArrayList 정렬
        Collections.sort(list);
		StringBuilder sb= new StringBuilder();
		
		for(int x: arr) {
		int ans= Collections.binarySearch(list, x);
		sb.append(ans).append(" ");
		
		}
		
		System.out.print(sb);
		
	}

}