import java.io.*;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		
		while(n-->0) {
		
		int ins= Integer.parseInt(br.readLine());
		
		if(ins == 0) {
			
			if(pq.isEmpty()) sb.append(0).append("\n");
			else sb.append(pq.poll()).append("\n");
			
			
			
		}else{
		
			pq.add(ins);
			
		}
		}
		
		System.out.print(sb);
	}
}