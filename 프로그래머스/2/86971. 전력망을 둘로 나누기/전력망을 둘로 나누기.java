import java.util.*;

class Solution {
       
    public int solution(int n, int[][] wires) {
        int ans= Integer.MAX_VALUE;
      //제일 확실한 방법은, 그냥 모든 연결고리를 끊어보는 것
      //그래프 문제
      ArrayList<Integer>[] graph= new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
            graph[i]= new ArrayList<>();
        
        for(int i=0; i<wires.length; i++){
            
            int from= wires[i][0];
            int to= wires[i][1];
            
            graph[from].add(to);
            graph[to].add(from);
            
        }
        
        for(int i=0; i<wires.length; i++){
            
            int from= wires[i][0];
            int to= wires[i][1];
            
            int val = bfs(from,to, wires, graph, n);
            
            ans= Math.min(Math.abs(n - 2* val), ans);
            
        }
        
        return ans;
    }
    
    static int bfs(int from, int to, int[][] wires, ArrayList<Integer>[] graph, int n){
        
        Queue<Integer> q= new ArrayDeque<>();
        boolean[] vis= new boolean[n+1];
        int cnt= 1;
        
        q.offer(from);
        vis[from]= true;
        
        while(!q.isEmpty()){
            
            int cur= q.poll();
            
            for(int node: graph[cur]){
                if(vis[node] || node==to) continue;
                vis[node]= true;
                q.add(node);
                cnt++;
            }
        }
        
        return cnt;
    }
}