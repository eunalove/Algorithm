/*총 백만개의 갯수, 수의 절댓값은 백만...
Arrays.sort는 O(nlogn) - O(O^2)인 반면
Collections.sort는 O(n) ~ O(nlogn)을 보장한다
그리고 출력은 반드시 SringBuilder
출력에도 시간이 많이 들어간다
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		ArrayList<Integer> arr= new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb= new StringBuilder();
		
		for(int a: arr) {
			sb.append(a).append("\n");
		}
		
		System.out.print(sb);
		
		
	}

}