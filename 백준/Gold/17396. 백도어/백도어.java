import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Data implements Comparable<Data>{

        int idx;
        long w;

        public Data(int idx, long w){
            this.idx= idx;
            this.w= w;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(this.w, o.w);
        }

    }

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int see[]= new int[v];
        for(int i=0; i<v; i++)
            see[i]= Integer.parseInt(st.nextToken());

        see[v-1]= 0;

        //1. 거리를 계산할 배열
        long dist[] = new long[v];

        for (int i = 0; i < v; i++)
            dist[i] = Long.MAX_VALUE;

        //2. pq를 통해서 배열의 거리보다 작으면 pq꺼내기
        PriorityQueue<Data> pq = new PriorityQueue<>();

        //3. 다익스트라에 사용될 그래프
        ArrayList<int[]>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++)
            graph[i] = new ArrayList<int[]>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, w});
            graph[to].add(new int[]{from, w});

        }

        boolean[] visited= new boolean[v];

        pq.add(new Data(0,0));
        dist[0]= 0;


        while (!pq.isEmpty()) {

            Data cur= pq.poll();

            if(visited[cur.idx]) continue;
            visited[cur.idx]= true;

            //만약 dist[대상 v] > dist[현재v]+ 대상v까지의 거리라면
            //dist[대상v]를 갱신하고 pq에 넣는다

            for(int[] tmp: graph[cur.idx]){ //2

                if(see[tmp[0]]== 0) {
                    if (dist[tmp[0]] > cur.w + tmp[1]) {
                        dist[tmp[0]] = cur.w + tmp[1];
                        pq.offer(new Data(tmp[0], dist[tmp[0]]));
                    }
                }

            }

        }

        if(dist[v-1] == Long.MAX_VALUE) System.out.print(-1);
        else System.out.print(dist[v-1]);
    }
}