import java.io.*;
import java.util.*;

class Solution {
    
    static int ans;
    static int total;
    static ArrayList<Integer>[] win;
    static ArrayList<Integer>[] lose;
    
    public int solution(int n, int[][] results) {
        
        total= n;
        //이긴 그래프 생성
        win = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
            win[i]= new ArrayList<Integer>();
        
        //진 그래프 생성
        lose = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
            lose[i]= new ArrayList<Integer>();
        
        //그래프에 입력값 채우기
        for(int i=0; i<results.length; i++){
            
            int from= results[i][0];
            int to= results[i][1];
            
            win[from].add(to);
            lose[to].add(from);
            
        }
        
        for(int i=1; i<=n; i++)
            bfs(i);
        
        return ans;
    }
    
    static void bfs(int cnt){ //n이 정확하게 순위를 매길 수 있는 선수인지 확인하는 함수
        
        Queue<Integer> q= new ArrayDeque<Integer>();
        boolean[] visited= new boolean[total+1];
        
        q.add(cnt);
        visited[cnt]= true;
        
        //bfs를 이용해서 이긴그래프를 탐색
        while(!q.isEmpty()){
            
            int node= q.poll();//1
            
            for(int x: win[node]){
                if(visited[x]) continue;
                
                visited[x]= true;
                q.add(x);
                
            }
            
        }
        
        q.add(cnt);
        visited[cnt]= true;
        
        //bfs를 이용해서 진 그래프를 탐색
        while(!q.isEmpty()){
            
            int node= q.poll();//1
            
            for(int x: lose[node]){
                if(visited[x]) continue;
                
                visited[x]= true;
                q.add(x);
                
            }
            
        }
        
        boolean flag= false;
        
        for(int i=1; i<=total; i++)
            if(!visited[i]) flag= true;

        
        //visited[]가 모두 채워져있다면 ans++;
        if(!flag) ans++;
        
    }
}