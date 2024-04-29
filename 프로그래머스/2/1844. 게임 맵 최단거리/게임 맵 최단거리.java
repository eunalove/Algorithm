import java.util.*;

class Solution {
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    
    static class Node{
        int x; int y; int time;
        public Node(int x, int y, int time){
            this.x= x;
            this.y= y;
            this.time= time;
        }
    }
    
    public int solution(int[][] maps) {
        int ans = 0;
        int n= maps.length;
        int m= maps[0].length;
        
        Queue<Node> q= new ArrayDeque<Node>();
        q.add(new Node(0,0,0));
        
        boolean[][] vis= new boolean[n][m];
        vis[0][0]= true;
        
        while(!q.isEmpty()){
            
            Node node= q.poll();
            if(node.x == n-1 && node.y == m-1) return node.time+1;
            
            for(int i=0; i<4; i++){
                int nx= node.x+ dx[i];
                int ny= node.y+ dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || maps[nx][ny]==0 ) continue;
                
                if(!vis[nx][ny]){
                    vis[nx][ny]= true;
                    q.add(new Node(nx, ny, node.time+1));
                }
            }
            
        }
        
        return -1;
    }
}