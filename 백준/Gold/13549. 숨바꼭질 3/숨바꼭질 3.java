import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int K= sc.nextInt();
        boolean[] visited= new boolean[200001];

        if(N == K) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<int[]> queue= new ArrayDeque();

        queue.add(new int[]{N,0});
        visited[N] =true;

        while(!queue.isEmpty()){

            int[] node= queue.poll();

            int nx= node[0]*2;
            if(nx == K) {
                System.out.print(node[1]);
                break;
            }
            if(nx < 100001 && !visited[nx]) {
                queue.add(new int[]{nx, node[1]});
                visited[nx]= true;
            }
            nx= node[0]-1;
            if(nx == K) {
                System.out.print(node[1]+1);
                break;
            }
            if(nx >= 0 && !visited[nx]) {
                queue.add(new int[]{nx, node[1]+1});
                visited[nx]= true;
            }

            nx= node[0]+1;
            if(nx == K) {
                System.out.print(node[1]+1);
                break;
            }
            if(nx < 100001 && !visited[nx]) {
                queue.add(new int[]{nx, node[1]+1});
                visited[nx]= true;
            }



        }

    }

}
