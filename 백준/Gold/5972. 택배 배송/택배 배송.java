import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph= new ArrayList[v+1];

        for(int i=1; i<=v; i++)
            graph[i]= new ArrayList<int[]>();

        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to,w});
            graph[to].add(new int[]{from, w});
        }

        int[] dist= new int[v+1];

        for(int i=1; i<=v; i++)
            dist[i]= Integer.MAX_VALUE;

        dist[1]= 0;

        PriorityQueue<int[]> pq= new PriorityQueue<>((p1, p2)->{return p1[1]- p2[1];});

        pq.add(new int[]{1,0});

        while(!pq.isEmpty()){

            int[] cur= pq.poll(); //첫번째 인자는 정점, 두번째 인자는 가중치

            for(int[] tmp: graph[cur[0]]){

                if(dist[cur[0]]+ tmp[1] < dist[tmp[0]]){

                    dist[tmp[0]]= dist[cur[0]]+ tmp[1];
                    pq.add(new int[]{tmp[0], dist[tmp[0]]});
                }
            }
        }

        System.out.print(dist[v]);

    }

}