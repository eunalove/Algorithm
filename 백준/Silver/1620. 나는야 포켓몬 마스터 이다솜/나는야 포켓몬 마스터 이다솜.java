import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		Map map1= new HashMap<Integer, String>();
		Map map2= new HashMap<String, Integer>();
		
		for(int i=1; i<n+1; i++) {
			String str= br.readLine();
			map1.put(i, str);
			map2.put(str, i);
		}
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0; i<m; i++) {
			String str= br.readLine();
			if(Pattern.matches("\\d+", str)) sb.append(map1.get(Integer.parseInt(str))).append("\n");
			else sb.append(map2.get(str)).append("\n");
		}
		
		System.out.print(sb);
		
		
		
		
	}

}