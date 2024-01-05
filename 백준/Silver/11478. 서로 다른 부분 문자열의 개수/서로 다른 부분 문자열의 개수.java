import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s = br.readLine();
		Set<String> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			func(s, set, i);
		}
		
		bw.write(String.valueOf(set.size()));
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	
	public static void func(String s, Set<String> set, int len) {
		for(int i = 0; i < s.length()-len; i++) {
			set.add(s.substring(i, i+1+len));
		}
	}
	
	
}