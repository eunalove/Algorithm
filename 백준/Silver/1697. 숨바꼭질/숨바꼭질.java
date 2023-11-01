import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n= sc.nextInt();
		int k= sc.nextInt();
		
		Queue<int[]> queue= new ArrayDeque<int[]>();
		boolean visited[]= new boolean[400001];
		
		queue.offer(new int[] {n, 0});
		
		while(!queue.isEmpty()) {
			
			int[] node= queue.poll();
			if(node[0] == k) {
				System.out.print(node[1]);
				break; 
			}
			
			if(!visited[node[0]] && node[0] > -1 && node[0] < 200001) {
				
				visited[node[0]]= true;
			
				if(node[0] > 0) {
			queue.add(new int[]{node[0]-1, node[1]+1});
				}
			queue.add(new int[]{node[0]+1, node[1]+1});
			
			queue.add(new int[]{node[0]*2, node[1]+1});
			}
		}
		
	}

}