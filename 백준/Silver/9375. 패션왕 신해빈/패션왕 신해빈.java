import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st= null;
		
		int t= Integer.parseInt(br.readLine());
		
		for(int T=0; T<t; T++) {
			
		Map<String, Integer> map= new HashMap();
		int n= Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			
			st= new StringTokenizer(br.readLine());
			String s1= st.nextToken();
			String s2= st.nextToken();
			
			map.put(s2, map.getOrDefault(s2, 0)+1);
			
		}
		
		int ans= 1;
		
		for(String key: map.keySet()) {
			ans= ans* (map.get(key)+1);
		}
		
		sb.append(ans-1+"\n");
		
		
		}
		
		System.out.print(sb);
	}

}