import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static Queue<Integer> q;
    static int[] fw;
    static boolean[] visited;
    static int ans;
    static int v;

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        graph= new ArrayList[v+1];
        for(int i=1; i<=v; i++)
            graph[i]= new ArrayList<Integer>();

        st= new StringTokenizer(br.readLine());

        fw= new int[v+1];
        for(int i=1; i<=v; i++){
            fw[i]= Integer.parseInt(st.nextToken());
        }

        //1. 양방향으로 그래프 저장
        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());

            graph[to].add(from);
            graph[from].add(to);
        }

        visited= new boolean[v+1];
        for(int i=1; i<=v; i++) {
            if(!visited[i]) {
                bfs(i);
            }
        }

        if(ans <= k) {
            System.out.print(ans);
        } else {
            System.out.print("Oh no");
        }
    }

    private static void bfs(int i) {
        q= new ArrayDeque<Integer>();
        q.add(i);
        visited[i]= true;

        int minFw= fw[i];

        //2. bfs로 그래프 돌리면서
        while(!q.isEmpty()) {

            int cur = q.poll(); //1

            for (int tmp : graph[cur]) { //3
                //그래프의 한 정점 당 큐에서 최솟값을 구함
                if(!visited[tmp]) {
                    visited[tmp]= true;
                    minFw = Math.min(minFw, fw[tmp]); //10
                    q.add(tmp);
                }
            }

        }
        //가장 작은 숫자로 갱신하기
        ans+= minFw;//10
    }
}