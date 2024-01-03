import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		Map map= new HashMap();
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			String str1= st.nextToken();
			String str2= st.nextToken();
			map.put(str1, str2);
		}
		
	StringBuilder sb= new StringBuilder();
	
	for(int i=0; i<m; i++) {
		String str= br.readLine();
		sb.append(map.get(str)).append("\n");
	}
		
		System.out.print(sb);
		
		
	}

}