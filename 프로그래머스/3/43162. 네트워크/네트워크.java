import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    static boolean visited[];
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        list= new ArrayList[n];
        visited= new boolean[n];
        
        //인접행렬을 인접리스트로 바꿈
        
        
        for(int i=0; i<n; i++){
            
            list[i]= new ArrayList();
            
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j || computers[i][j]== 0) continue;
                
                list[i].add(j);
                list[j].add(i);
                
            }
        }
        
        //인접리스트에서 dfs진행
        for(int i=0; i<n; i++){
         if(!visited[i]){
             answer += 1;
             dfs(i);
             
         }
            
        }
        
        return answer;
    
    }
    
        
        static public void dfs(int v){
        
        for(int x: list[v]){
            if(!visited[x]){
                visited[x]= true;
                dfs(x);
                
            }
            
        }
        
    }
    
}

    

    

    