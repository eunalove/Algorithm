import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        while(t-->0) {

        st= new StringTokenizer(br.readLine());
        int v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());
        int start= Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph= new ArrayList[v+1];
        for(int i=1; i<=v; i++)
            graph[i]= new ArrayList<int[]>();

        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[to].add(new int[]{from, w});

        }

        int[] dist= new int[v+1];
        for(int i=1; i<=v; i++)
            dist[i]= Integer.MAX_VALUE;
        PriorityQueue<int[]> pq= new PriorityQueue<>((pq1, pq2)->{return pq1[1]- pq2[1];});
        pq.add(new int[]{start, 0});
        dist[start]= 0;

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            for (int[] tmp : graph[cur[0]]) {

                if (dist[tmp[0]] > dist[cur[0]] + tmp[1]) {

                    dist[tmp[0]] = dist[cur[0]] + tmp[1];
                    pq.add(new int[]{tmp[0], dist[tmp[0]]});

                }

            }
        }

        int max= Integer.MIN_VALUE;
        int len= 0;

        for(int i=1; i<=v; i++) {
            if(dist[i] != Integer.MAX_VALUE) {
                max = Math.max(max, dist[i]);
                len++;
            }

        }

        sb.append(len).append(" ").append(max).append("\n");

        }
        System.out.print(sb);
    }
}