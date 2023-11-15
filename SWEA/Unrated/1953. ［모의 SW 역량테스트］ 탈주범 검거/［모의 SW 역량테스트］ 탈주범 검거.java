import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int n,m,tn,tm,time, ans;
    static int[][] map;
    static boolean visited[][];
    //상하좌우 0123
    static int[][] tunul = {null, {0,1,2,3}, {0,1}, {2,3}, {0,3}, {1,3}, {1,2}, {0,2}};
    static StringBuilder sb= new StringBuilder();
    
    static class Node{

        int x; int y; int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        int T= Integer.parseInt(br.readLine());

        for(int tc=1; tc<T+1; tc++) {

            ans= 0;
            
            st= new StringTokenizer(br.readLine());

            n= Integer.parseInt(st.nextToken());
            m= Integer.parseInt(st.nextToken());
            tn= Integer.parseInt(st.nextToken());
            tm= Integer.parseInt(st.nextToken());
            time= Integer.parseInt(st.nextToken());

            visited= new boolean[n][m];
            map= new int[n][m];

            for(int i=0; i<n; i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            simul();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        }
        
        System.out.print(sb);

    }

    static void simul() {

        //bfs시작
        Queue<Node> queue= new ArrayDeque<Node>();
        queue.add(new Node(tn, tm, 1));
        visited[tn][tm]= true;
    
        while(!queue.isEmpty()) {

            Node node= queue.poll();

            //time보다 시간이 지나면 끝
            if (time< node.time) {
                return;
            }

            ans+=1;
            
            //현재 타입에서 연결부만큼 for문을 돌려서 연결부를 확인한다
            for(int i=0; i<tunul[map[node.x][node.y]].length; i++) { // 0 1 2 3
                
                if(tunul[map[node.x][node.y]][i] == 0) { //상이라면

                    //상이라면 위에 있는 터널을 확인함
                    if(node.x-1 <0 || map[node.x-1][node.y]== 0) continue;

                    for(int j=0; j<tunul[map[node.x-1][node.y]].length; j++) {
                        if(tunul[map[node.x-1][node.y]][j]==1 && !visited[node.x-1][node.y]) { //접합부가 아래임 그러므로 연결됨
                            queue.offer(new Node(node.x-1, node.y, node.time+1));
                            visited[node.x-1][node.y]= true;
                        }
                    }
                }

                else if(tunul[map[node.x][node.y]][i] == 1) { //하라면

                    //아래에 있는 터널을 확인함
                    if(node.x+1 >=n || map[node.x+1][node.y]== 0) continue;

                    for(int j=0; j<tunul[map[node.x+1][node.y]].length; j++) {
                        if(tunul[map[node.x+1][node.y]][j]==0 && !visited[node.x+1][node.y]) { //접합부가 위임 그러므로 연결됨
                            queue.offer(new Node(node.x+1, node.y, node.time+1));
                            visited[node.x+1][node.y]= true;
                        }
                    }
                }

                else if(tunul[map[node.x][node.y]][i] == 2) { //좌라면

                    //왼쪽에 있는 터널을 확인함
                    if(node.y-1 <0 || map[node.x][node.y-1]== 0) continue;

                    for(int j=0; j<tunul[map[node.x][node.y-1]].length; j++) {
                        if(tunul[map[node.x][node.y-1]][j]==3 && !visited[node.x][node.y-1]) { //접합부가 오른쪽임 그러므로 연결됨
                            queue.offer(new Node(node.x, node.y-1, node.time+1));
                            visited[node.x][node.y-1]= true;
                        }
                    }
                }

                else if(tunul[map[node.x][node.y]][i] == 3) { //우라면

                    //오른쪽에 있는 터널을 확인함
                    if(node.y+1 >=m || map[node.x][node.y+1]== 0) continue;

                    for(int j=0; j<tunul[map[node.x][node.y+1]].length; j++) {
                        if(tunul[map[node.x][node.y+1]][j]==2 && !visited[node.x][node.y+1]) { //접합부가 왼쪽임 그러므로 연결됨
                            queue.offer(new Node(node.x, node.y+1, node.time+1));
                            visited[node.x][node.y+1]= true;
                        }
                    }
                }

            }

        }}
}