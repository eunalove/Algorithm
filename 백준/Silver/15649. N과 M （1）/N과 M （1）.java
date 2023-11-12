import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        N= sc.nextInt();
        M= sc.nextInt();

        ans= new int[M];
        visited = new boolean[N+1];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int L){

        if(L == M){

            for(int x: ans){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;

        }

        for(int i=1; i<N+1; i++) {

            if(visited[i]) continue;
            ans[L] = i;
            visited[i] = true;
            dfs(L + 1);
            visited[i] = false;

        }



    }
}