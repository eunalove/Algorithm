/*
오.. PriorityQueue()에서 pq에 대한 정렬방식을 지정해줄 수 있는지는 몰랐네
pq에서 바로바로 정렬해주면 n*(O(logn))이니까
시간복잡도는 O(nlogn)이 된다.
add나 isEmpty는 어차피 O(logn)이니까 상관없다
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>((int[] n1, int[] n2)->{
			if(n1[0] == n2[0]) return n1[1]- n2[1];
			else return n1[0]- n2[0];
		});
		
		while(n -->0) {
			
			int ins= Integer.parseInt(br.readLine());
			
			if(ins==0) {
				
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()[1]).append("\n");
					
				
				
			}else {
				
				pq.add(new int[] {Math.abs(ins), ins});
			}
		}
		
		System.out.print(sb);

	}

}