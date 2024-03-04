import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] p;
    static class Edge{

        int from; int to; int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to= to;
            this.w= w;

        }

    }

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int v= Integer.parseInt(br.readLine());
        int e= Integer.parseInt(br.readLine());

        //MST 크루스칼 알고리즘 ㄱㄱ

        Edge[] edges= new Edge[e];

        StringTokenizer st= null;
        for(int i=0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());

            edges[i]= new Edge(from, to, w);

        }
        
        long ans= 0;

        p = new int[v+1];
        for(int i=1; i<=v; i++)
            p[i]= i; //자기자신을 부모로 둔다

        //w를 기준으로 정렬
        Arrays.sort(edges, (e1,e2)->{return e1.w- e2.w;});

        for(int i=0; i<e; i++){
                //다른 집합이면 값 추가
                if(!union(edges[i].from,edges[i].to))
                    ans+= edges[i].w;

        }

        System.out.print(ans);
    }

    private static boolean union(int a, int b) {

        a= find(a);
        b= find(b);

        if(a==b) return true;

            p[b]= a;
            return false;


    }

    private static int find(int a) {

        if(a==p[a]) return a;

        return p[a]= find(p[a]);

    }


}