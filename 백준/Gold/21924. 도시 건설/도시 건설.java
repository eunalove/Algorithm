import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge{
        int v1; int v2; long w;
        public Edge(int v1, int v2, long w){
            this.v1= v1;
            this.v2= v2;
            this.w= w;
        }
    }

    static int[] p;

    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int v= Integer.parseInt(st.nextToken()); //건물 갯수
        int e= Integer.parseInt(st.nextToken()); //도로 갯수

        Edge[] edges= new Edge[e];
        p= new int[v+1];

        for(int i=0; i<=v; i++){
            p[i]= i;
        }

        long totalW= 0;

        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int v1= Integer.parseInt(st.nextToken());
            int v2= Integer.parseInt(st.nextToken());
            long w= Long.parseLong(st.nextToken());
            totalW+=w;
            edges[i]= new Edge(v1, v2, w);
        }

        Arrays.sort(edges, (e1, e2) -> Long.compare(e1.w, e2.w));

        long weight= 0;
        int cnt= 0;
        for(int i=0; i<e; i++){
            if(!union(edges[i].v1, edges[i].v2)){
                cnt++;
                weight+= edges[i].w;
            }
            if(cnt==v-1) break;
        }

        if(cnt== v-1){
            System.out.print(totalW- weight);
        }else{
            System.out.print(-1);
        }
    }

    static boolean union(int a, int b){
        a= find(a);
        b= find(b);
        if(a==b) return true;
        p[b]= a;
        return false;
    }

    static int find(int a){
        if(a == p[a]) return a;
        return p[a] = find(p[a]);
    }
}