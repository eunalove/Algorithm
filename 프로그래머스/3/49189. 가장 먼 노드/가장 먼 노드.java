import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int ans = 0;
        
        ArrayList<Integer>[] graph= new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
            graph[i]= new ArrayList<Integer>();
        
        //그래프 입력
        for(int i=0; i<edge.length; i++){
            
            int from = edge[i][0];
            int to= edge[i][1];
            
            graph[from].add(to);
            graph[to].add(from);
            
            }
        
        
        //거리를 저장할 dist배열, 1부터 세기
        int[] dist= new int[n+1];
        
        for(int i=2; i<=n; i++) //1번 노드는 0이여야함 나머지 초기화
            dist[i]= Integer.MAX_VALUE;
        
        Queue<Integer> q= new ArrayDeque<Integer>();
        q.add(1);
        
        boolean[] visited= new boolean[n+1];
        visited[1]= true;
        
        while(!q.isEmpty()){
            
            int tmp= q.poll();
            visited[tmp]= true;
            
                //for문 돌면서 현재 dist+ 다음 거리와 다음 dist 비교
                for(int x: graph[tmp]){
                if(visited[x]) continue;
                    
                    if(dist[tmp]+1 < dist[x]) {
                        dist[x]= dist[tmp]+1;
                        q.add(x);
                    }
                
                }
        }
        
        int max= -1;
        
        //dist돌면서 가장 큰 값을 체크
        for(int x: dist)
            max= Math.max(max, x);
        
        
        //dist를 다시 돌면서 같은 값이 몇개 있는지 체크
        for(int x: dist)
            if(x==max) ans++;
        
            
        return ans;
  }
                               
}