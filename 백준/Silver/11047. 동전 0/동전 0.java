import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int ans= 0;
		
		for(int i=list.size()-1; i>=0; i--) {
			if(list.get(i) > k) continue;
			
			ans+= k/list.get(i);
			k= k%list.get(i);
		}
		
		
		System.out.print(ans);
		
		
		
	}

}