import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		int[] map= new int[n*n];
		StringTokenizer st;
		int k= 0;
		
		
		for(int i=0; i<n; i++) {
		
			st= new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) 
			map[k++]= Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(map);
		
		System.out.println(map[n*n-n]);
		
		
	}

}