import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		
		Queue<Integer> queue= new ArrayDeque<Integer>();
		StringBuilder sb= new StringBuilder();
		int back = -1;
		
		for(int i=0; i<n; i++) {
		
			st= new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			
			case "push": int a= Integer.parseInt(st.nextToken());
						queue.add(a);
						back= a;
						break;
		
			case "pop": sb.append(queue.isEmpty()? -1: queue.poll()).append("\n");
						break;
				
			case "size": sb.append(queue.size()).append("\n");
						break;
				
			case "empty": sb.append(queue.isEmpty()? 1: 0).append("\n");
						break;
			
			case "front": sb.append(queue.isEmpty()? -1: queue.peek()).append("\n");
						break;
			
			case "back": sb.append(queue.isEmpty()? -1: back).append("\n");
						break;
			
			}
	}
		
	System.out.print(sb);
	}
}