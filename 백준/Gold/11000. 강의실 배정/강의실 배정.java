
import java.util.*;
import java.io.*;

public class Main {
	
	static class lecture implements Comparable<lecture>{ 
		
		int start;
		int finish;
		
		
		public lecture(int start, int finish) {
			this.start= start;
			this.finish= finish;
		}


		@Override
		public int compareTo(lecture o) {
			if(this.start == o.start) {
				return this.finish- o.finish;
			}
			return this.start-o.start;
		}
		
	}
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st;

	        int N = Integer.parseInt(br.readLine());
	        lecture[] lectures = new lecture[N];
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());

	            int start = Integer.parseInt(st.nextToken());
	            int end = Integer.parseInt(st.nextToken());
	            lectures[i] = new lecture(start, end);
	        }  
         
	        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.finish - l2.finish : l1.start - l2.start);

	        // 우선순위 큐에는 종료 시간만 들어가며, 오름차순으로 자동 정렬된다.
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        pq.offer(lectures[0].finish);

	        for (int i = 1; i < N; i++) {
	            // 우선순위 큐에서 가장 작은 종료 시간과
	            // 현재 lectures[i]의 시작 시간을 비교한다.
	            if (pq.peek() <= lectures[i].start) {
	                pq.poll();
	            }
	            pq.offer(lectures[i].finish);
	        }

	        // 현재 우선순위 큐에 남아있는 요소의 개수가 필요한 최소한의 강의실 개수이다.
	        System.out.print(pq.size());
	    }
}