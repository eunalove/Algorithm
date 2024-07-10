import java.util.*;

class Solution {
        
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] list= new ArrayList[n];
        
        for(int i=0; i<n; i++)
            list[i]= new ArrayList<Integer>();
        
        for(int from=0; from<n; from++){
            for(int to=0; to<n; to++){
                if(computers[from][to] == 1){
                list[from].add(to);
                //list[to].add(from);
                }
            }
        }
        
        for(int i=0; i<list.length; i++)
            System.out.println(list[i]);
        
        boolean[] vis= new boolean[n];
        int ans= 0;
        boolean flag= false;
        for(int i=0; i<n; i++){
            for(boolean v: vis)
                if(!v) flag= true;
                
            if(!flag) break;
            if(!vis[i]){
                ans++;
                bfs(i, vis, list);
            }
        }
        return ans;
    }
    
    static void bfs(int start, boolean[] vis, ArrayList<Integer>[] list){
        
        Queue<Integer> q= new ArrayDeque<>();
        q.add(start);
        System.out.println(start);
        while(!q.isEmpty()){
            
            int cur= q.poll();
            
            for(int tmp: list[cur]){
                
                if(vis[tmp]) continue;
                vis[tmp]= true;
                q.add(tmp);
            }
            
        }
        
    }
    
}

    

    

    