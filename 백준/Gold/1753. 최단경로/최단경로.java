import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V,E;
	static int K; //시작정점
	static ArrayList<Data>[] list;
	static int[] D;
	static int INF= 999_999_999;
	static boolean[] visited;
	
	static class Data implements Comparable<Data>{
		int v,w;

		public Data(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Data [v=" + v + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) {
		
	Scanner sc= new Scanner(System.in);
	V= sc.nextInt();
	E= sc.nextInt();
	K= sc.nextInt();
		
	list= new ArrayList[V+1];
	D= new int[V+1];
	visited= new boolean[V+1];
	
	for(int i=1; i<V+1; i++)
		list[i] = new ArrayList<Data>();
	
	int u,v,w;
	
	for(int i=0; i<E; i++) {
		u = sc.nextInt();
		v = sc.nextInt();
		w = sc.nextInt();
		list[u].add(new Data(v, w));
		
	}
	
	//다익스트라 구현
	Arrays.fill(D, Integer.MAX_VALUE);
	
	PriorityQueue<Data> pQueue  = new PriorityQueue<>();
	//시작 정점을 PQ에 삽입하기
	pQueue.offer(new Data(K, 0));
	D[K]=0;
	
	//큐가 빌 때까지 로직 구현(모든 정점까지의 비용이 구해질때까지)
	Data cur;
	int cnt= 0;
	while(!pQueue.isEmpty()) {
		//한 개 뽑아서 최단거리로 사용하기
		cur= pQueue.poll();
	
		//이미 사용된 정점이면 무시하기
		if(visited[cur.v])
			continue;
		
		visited[cur.v] = true;//최단거리가 구해진 정점임
		cnt++;
		
		if(cnt==V) //이 부분이 잘 이해가 안가...
			break;
		
		//현재 연결된 정점에서 연결된 (최단거리가 아직 구해지지 않은)다른 정점의 비용을 업데이트하고
		//큐에 삽입하기
		for(Data d: list[cur.v]) {
			if(visited[d.v])//사용중이면 컨티뉴
				continue;
			
			if(D[d.v] > D[cur.v]+ d.w) {
				D[d.v] = D[cur.v]+ d.w;
				pQueue.offer(new Data(d.v, D[d.v]));
			
			}
		}
	}
		
	//출력
		
	for(int i=1; i<= V; i++){
		System.out.println(D[i] == Integer.MAX_VALUE ? "INF": D[i]);
	}
	
	}

}
