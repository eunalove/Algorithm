import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long c;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		long a= Integer.parseInt(st.nextToken());
		

		long b= Integer.parseInt(st.nextToken());

		c= Integer.parseInt(st.nextToken());
		a= a%c;


		System.out.println(dfs(a, b));
		
	}

	static long dfs(long a, long b) {

		if(b == 1) {
			return a%c;
		}
		
		if(b%2 == 0) {
			Long num= dfs(a, b/2)%c;
			return  (num * num) %c;
		}else {
			Long num= dfs(a, b/2)%c;
			return  (num * num %c)*a%c;
		}
		
	}



}