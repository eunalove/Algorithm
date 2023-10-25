import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] operArr;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		operArr = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operArr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int result, int depth) {
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operArr[i] > 0) {
				operArr[i]--;
				switch (i) {
					case 0:
						dfs(result + arr[depth], depth + 1);
						break;
					case 1:
						dfs(result - arr[depth], depth + 1);
						break;
					case 2:
						dfs(result * arr[depth], depth + 1);
						break;
					case 3:
						dfs(result / arr[depth], depth + 1);
						break;
				}
				operArr[i]++;
			}
		}
	}
}