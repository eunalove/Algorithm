import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			ans= 0;
		
		int n= Integer.parseInt(br.readLine()); //3
		
		dfs(n);
		sb.append(ans).append("\n");
		
		
		
	}
		System.out.print(sb);

}

	 static void dfs(int n) {
		 
		 //기저조건: 0이랑 같거나 작으면 리턴함
		 if(n == 0) {
			 ans+=1;
			 return;
		 }
		 
		 if(n>=1) {
		 dfs(n-1);
		 }
		 
		 if(n>=2) {
		 dfs(n-2);
		 }
		 if(n>=3) {
		 dfs(n-3);
		 }
		 
	}
}