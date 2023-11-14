import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
         n = Integer.parseInt(br.readLine());

         map = new int[n][n];

         for(int i=0; i<n; i++){
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<n; j++){
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
         }

        visited = new boolean[n];
        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int start) {

        if (depth== n/2) {
            diff();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
        }

        static void diff() {

        int start =0;
        int link =0;

        for(int i=0; i< n-1; i++){
            for(int j=i; j<n; j++){

                if(visited[i] && visited[j]){
                    start += map[i][j];
                    start += map[j][i];
                } else if(!visited[i] && !visited[j]){
                    link += map[i][j];
                    link += map[j][i];

                }

            }
        }

        int val = Math.abs(start- link);
        min= Math.min(val, min);

    }
}
