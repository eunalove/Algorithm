import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static int ans= Integer.MAX_VALUE;
    static int[][] wires2;
    
    public int solution(int n, int[][] wires) {
        wires2= new int[wires.length][2];
        
        for(int i=0; i<wires.length; i++){
            wires2[i][0]= wires[i][0];
            wires2[i][1]= wires[i][1];
        }
        
        for(int i=0; i< wires.length; i++){
            init(i, n);
            bfs(wires[0][0], n);
        }
        
        return ans;
    }
    
    static void init(int cur, int n){
        graph= new ArrayList[n+1];
        
        for(int i=1; i<=n; i++)
            graph[i]= new ArrayList<Integer>();
        
         for(int i=0; i<wires2.length; i++){
            if(i == cur) continue;
            graph[wires2[i][0]].add(wires2[i][1]);
            graph[wires2[i][1]].add(wires2[i][0]);
            
        }
        
    }
        
    static void bfs(int cur, int n){
        
        Queue<Integer> q= new ArrayDeque<Integer>();
        q.add(cur);
        
        boolean[] vis= new boolean[n+1];
        vis[cur]= true;
        
        while(!q.isEmpty()){
            
            int tmp= q.poll();
            
            for(int x: graph[tmp]){
                
                if(!vis[x]){
                    vis[x]= true;
                    q.add(x);
                }
                
            }
        }
        
        int one = 0;
        for(boolean v : vis) {
            if(v) one++;
        }
        int two = n - one; // 전체 노드 수에서 one을 빼서 다른 그룹의 크기를 구함
        
        ans = Math.min(ans, Math.abs(one-two));
        
        
    }
}