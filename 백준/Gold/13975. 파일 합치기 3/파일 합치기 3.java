import java.io.*;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		StringBuilder sb= new StringBuilder();
		
		PriorityQueue<Long> pq;
		int t= Integer.parseInt(br.readLine());
		
		while(t-->0) { //2
		pq= new PriorityQueue<Long>();
		int n= Integer.parseInt(br.readLine()); //4
		int m= n-1; //3
		long sum= 0;
		
		st= new StringTokenizer(br.readLine());
		while(n-->0){
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		while(m-->0) {
			long x= pq.poll()+ pq.poll();
			pq.add(x);
			sum+=x;
			
		}
		sb.append(sum).append("\n");
		}
		
		System.out.print(sb);
		
	}

}