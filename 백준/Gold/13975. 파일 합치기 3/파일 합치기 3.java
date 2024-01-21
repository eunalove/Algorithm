//long타입은 구십 이경 이십 삼조 삼천 칠백 이십 삼경 삼십 칠조 이십 일억 팔천 팔백이다...
//이때까지 long타입이 2의64승-1인줄은 알았지만 실제로보니 훨씬 어마어마하게 큰 값이었다
//백만*만이면 백억이 되므로 int타입을 넘는다

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