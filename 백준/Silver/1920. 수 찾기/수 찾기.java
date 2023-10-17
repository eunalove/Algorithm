import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int map1[] = new int[n];
		for (int i = 0; i < n; i++) {
			map1[i] = Integer.parseInt(st.nextToken());
		}

		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int map2[] = new int[m];
		for (int i = 0; i < m; i++) {
			map2[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map1);
		
		for(int i=0; i<m; i++) {
			if(Arrays.binarySearch(map1, map2[i]) < 0) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
		}
		
		
		
		
		

	}

}