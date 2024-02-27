import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Emo{

        int screen; int clip; int time;

        public Emo(int screen, int clip, int time){

            this.screen= screen;
            this.clip= clip;
            this.time= time;

        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int s= sc.nextInt();

        Queue<Emo> q= new ArrayDeque<Emo>();
        boolean[][] visited = new boolean[2001][2001];

        //큐에 이미 화면에 있는 이모티콘을 넣는다
        q.add(new Emo(1,0,0));
        visited[1][0] = true;

        //세가지 연산이 가능하다
        while(!q.isEmpty()) {

            Emo tmp= q.poll();

            //이모티콘이 s개인지 확인
            if(tmp.screen == s){
                System.out.print(tmp.time);
                break;
            }

            //1. 화면에 있는 이모티콘을 모두 복사
            if(!visited[tmp.screen][tmp.screen]){
                q.add(new Emo(tmp.screen, tmp.screen, tmp.time+1));
                visited[tmp.screen][tmp.screen] = true;
            }

            //2. 클립보드에 있는 이모티콘을 모두 붙여넣기
            if(tmp.screen + tmp.clip <= 2000 && !visited[tmp.screen+ tmp.clip][tmp.clip]){
                q.add(new Emo(tmp.screen+ tmp.clip, tmp.clip, tmp.time+1));
                visited[tmp.screen+ tmp.clip][tmp.clip] = true;
            }

            //3. 화면에 있는 이모티콘 1개 삭제
            if(tmp.screen > 1 && !visited[tmp.screen - 1][tmp.clip]) {
                q.add(new Emo(tmp.screen - 1, tmp.clip, tmp.time + 1));
                visited[tmp.screen - 1][tmp.clip] = true;
            }

        }
    }
}