/*
배열을 넣어서 정렬 후 앞의 2개씩 뽑아서 더하는 방식은 반례가 있음
예를 들어서 20 40 45 50인 경우 (20+40)+(45+50)+(60+95)가 최소다
하지만 내가 한 방식대로 배열에 넣어서 한번만 정렬하면 (20+40)+(60+45)+(105+50)이 되어버린다.
*/
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		//숫자가 작은 순서대로 카드를 묶음
		
		if(n==1) {
			System.out.print(0);
			
		}else {
			
			//숫자를 저장할 pq
			PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
			
			while(n--> 0) {
				pq.add(Integer.parseInt(br.readLine()));
			}
			
			int sum= 0;
			int ans= 0;
			
			while(pq.size()>1) {
				
				sum = pq.poll()+ pq.poll();
				ans+= sum;
				pq.add(sum);
				
			}
			
		
		System.out.print(ans);
		
		}
	}

}