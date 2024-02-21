import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        //0. 들어오는 간선을 기록한 배열
        int[] indegree= new int[n+1];

        ArrayList<Integer>[] list= new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i]= new ArrayList<>();
        }

        for(int i=0; i<m; i++){

            st= new StringTokenizer(br.readLine());
            int para1= Integer.parseInt(st.nextToken());
            int para2= Integer.parseInt(st.nextToken());

            indegree[para2]++;
            list[para1].add(para2);

        }

        StringBuilder sb= new StringBuilder();
        Queue<Integer> q= new ArrayDeque<Integer>();
        for(int i=1; i<=n; i++){

            //1. 들어오는 간선이 없는 정점을 찾아서 큐에 넣는다
            if(indegree[i] == 0) q.offer(i);

            while(!q.isEmpty()) {

                int num = q.poll();// 3
                sb.append(num).append(" ");

                    for (Integer x : list[num]) {

                        indegree[x]--; //1에서 뻗어나간 간선을 지움
                        if (indegree[x] == 0) {
                            q.offer(x);
                            indegree[x]= -1;
                        }
                        //왜냐면 for문은 한번만 도니까
                        //예를 들어 3 1인 경우는 1이 0이 됐을 때 넣어줘야함
                    }
                }
            }


        System.out.print(sb);

    }
}