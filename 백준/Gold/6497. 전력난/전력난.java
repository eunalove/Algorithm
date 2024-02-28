import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge{
        int v1; int v2; int value;

        public Edge(int v1, int v2, int value){
            this.v1= v1;
            this.v2= v2;
            this.value= value;
        }
    }

    static int[] p;

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(v==0 && e==0) break;

            Edge[] edges = new Edge[e];

            p = new int[v + 1];
            for (int i = 0; i <= v; i++)
                p[i] = i;

            int x = -1;
            int total = 0;

            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                total += w;

                edges[++x] = new Edge(v1, v2, w);

            }
            Arrays.sort(edges, (e1, e2) -> {
                return e1.value - e2.value;
            });

            long ans = 0;

            for (int i = 0; i < e; i++) {
                if (!union(edges[i].v1, edges[i].v2)) {
                    ans += edges[i].value;
                }
            }

            sb.append(total-ans).append("\n");
        }

        System.out.print(sb);

    }

    private static boolean union(int v1, int v2) {

        int a= find(v1);
        int b= find(v2);

        if(a==b) return true;
        p[b]= a;
        return false;


    }

    private static int find(int a) {

        if(p[a]== a) return a;
        return p[a]= find(p[a]);

    }
}