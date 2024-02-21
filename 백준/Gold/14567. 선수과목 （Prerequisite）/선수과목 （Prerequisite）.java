import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] answer= new int[n+1];
        int[] indegree= new int[n+1];
        //그래프 생성
        ArrayList<Integer>[] list = new ArrayList[n + 1];

        //그래프 초기화
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int para1 = Integer.parseInt(st.nextToken());
            int para2 = Integer.parseInt(st.nextToken());

            indegree[para2]++;
            list[para1].add(para2);

        }

        Queue<Integer> q= new ArrayDeque<>();
        //들어오는 차수가 없는 정점을 큐에 추가
        for(int i=1; i<=n; i++){
            if(indegree[i]== 0) q.offer(i);
        }

        int semester= 0; //현재 학기
        while(!q.isEmpty()){
            int re= q.size();
            semester++;

            for(int i=0; i<re; i++){ //현재 같은 indgree를 가진 정점들을 돈다

                int cur= q.poll();
                answer[cur] = semester;
                for(int x: list[cur]){
                    indegree[x]--;
                    if(indegree[x]== 0) q.offer(x);

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);
    }
}