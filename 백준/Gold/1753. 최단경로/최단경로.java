import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        //1. 첫 시작점에서 갈 수 있는 곳들의 거리와 최단거리 표의 값을 비교한다
        //2. 만약 갈 수 있는 곳의 거리가 작으면 최단거리 표의 값을 바꾸고
        //우선순위 큐에 넣는다
        //3. 가장 거리가 작은 걸 우선순위 큐에서 꺼내서 1번으로 도르마무

        int v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());

        int start= Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph= new ArrayList[v+1];

        for(int i=1; i<=v; i++)
            graph[i]= new ArrayList<>();

        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());

            int v1= Integer.parseInt(st.nextToken());
            int v2= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());

            graph[v1].add(new int[]{v2, w});
        }

        int[] distance= new int[v+1]; //최단거리를 저장할 배열
        for(int i=1; i<=v; i++)
            distance[i]= Integer.MAX_VALUE; //초기화

        PriorityQueue<int[]> pq= new PriorityQueue<int[]>((p1, p2)->{
            return p1[1]- p2[1];
        }); //가장 거리가 작은 정점을 찾아낼 pq

        pq.add(new int[]{start, 0});
        distance[start]= 0;

        while(!pq.isEmpty()) {

            int[] tmp= pq.poll();

            for (int[] x : graph[tmp[0]]) { //0번째는 대상 정점, 1번째는 가중치
                if (x[1]+ distance[tmp[0]] < distance[x[0]]) { //만약 최단거리 배열이 더 크다면

                    distance[x[0]] = x[1]+ distance[tmp[0]];
                    pq.add(new int[]{x[0], x[1]+ distance[tmp[0]] }); //pq에 추가함

                }
            }
        }

        StringBuilder sb= new StringBuilder();

        for(int i=1; i<=v; i++) {
            if(distance[i]== Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }
        System.out.print(sb);
    }
}