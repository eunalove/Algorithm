import java.io.*;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
		
		while(n--> 0) {
		
		int ins= Integer.parseInt(br.readLine());
		
		if(ins != 0) {
			
			//배열에 x를 넣는다
			pq.add(ins);
			
		}else {
			
			//만약 비어있다면 0을 출력
			if(pq.isEmpty()) sb.append(0).append("\n");
			//아니라면 가장 큰 값을 출력함
			else sb.append(pq.poll()).append("\n");
			
			
		}
		
		}
		
		System.out.print(sb);
		
	}

}