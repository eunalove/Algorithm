import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx= {-1, 0, 1, 0};
    static int[] dy= {0, 1, 0, -1};

    static class gosm{
        int x; int y; int time;

        public gosm(int x, int y, int time){
            this.x= x;
            this.y= y;
            this.time= time;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int r= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());

        char[][] map= new char[r][c];

        //물이 차는 시간을 저장
        Queue<int[]> water= new ArrayDeque<>();
        Queue<gosm> gosmdochi= new ArrayDeque<>();
        int[] biber= new int[2];

        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') water.offer(new int[]{i, j});
                else if (map[i][j] == 'S') gosmdochi.offer(new gosm(i, j, 0));
                else if (map[i][j] == 'D') {
                    biber[0] = i;
                    biber[1] = j;
                }
            }
        }

        while(!gosmdochi.isEmpty()){

            int wsize= water.size();

            while(wsize-->0){ //물 먼저 흩뿌리기

                int[] node= water.poll();

                for(int i=0; i<4; i++) {

                    int nx = node[0] + dx[i];
                    int ny = node[1] + dy[i];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                    if(map[nx][ny]== '.') {
                        map[nx][ny] = '*';
                        water.offer(new int[]{nx, ny});
                    }
                }
            }

            int gsize= gosmdochi.size();
            while(gsize--> 0){

                gosm node= gosmdochi.poll();

                for(int i=0; i<4; i++) {

                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                    if(map[nx][ny]== 'D'){
                        System.out.print(node.time+1);
                        System.exit(0);
                    }
                    if (map[nx][ny] == '.') {

                        map[nx][ny] = 'S';
                        gosmdochi.offer(new gosm(nx, ny, node.time + 1));
                    }
                }

            }

        }

        System.out.print("KAKTUS");

    }
}