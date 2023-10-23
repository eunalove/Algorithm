import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());

		int ans = 0;

		for (int i = 0; i < n; i++) {

			if (Arrays.binarySearch(arr, x - arr[i]) >= 0)
				ans += 1;

		}
		System.out.print(ans/2);

	}

}