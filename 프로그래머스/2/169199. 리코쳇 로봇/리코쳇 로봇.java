import java.util.*;
import java.io.*;

class Solution {
    
    static class Node{
        
        int x; int y; int time;
        
        public Node(int x, int y, int time){
            
            this.x= x;
            this.y= y;
            this.time= time;
            
        }  
    }
    
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    
    
    public int solution(String[] board) {
        int n= board.length;
        int m= board[0].length();
        
        int[] start= new int[2];
        int[] end= new int[2];
        
        int[][] map =new int[n][m];
        
        //입력값 받기
        //map에 .이면 0, D면 1 표시, R이면 start, G면 end
        for(int i=0; i<n; i++){
            String str= board[i];
            for(int j=0; j<m; j++){
                char c= str.charAt(j);
                if(c=='.')
                    map[i][j]= 0;
                else if(c== 'D')
                    map[i][j]= 1;
                else if(c== 'R'){
                    start[0]= i;
                    start[1]= j;
                }else{
                    end[0]= i;
                    end[1]= j;
                }  
            }
            
        }
        
        //BFS탐색시작
        Queue<Node> q= new ArrayDeque();
        boolean[][] visited= new boolean[n][m];
        
        q.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]]= true;
        
        while(!q.isEmpty()){
            
            Node node= q.poll();
            //System.out.println(node.x+" "+node.y);
            
            if(node.x == end[0] && node.y == end[1]){
                return node.time;
            }
            
            for(int i=0; i<4; i++){
                //nx,ny는 장애물이나 끝을 만났을 때의 위치
            
                int nx= node.x;
                int ny= node.y;
                
                while(true){
                    
                    nx+= dx[i];
                    ny+= dy[i];
                    
                    if(nx<0 || ny<0 || nx>= n || ny>= m || map[nx][ny]== 1){
                        nx-= dx[i];
                        ny-= dy[i];
                        break;  
                    }
                    
                }
                
                if(!visited[nx][ny]){
                    
                    visited[nx][ny]= true;
                    q.add(new Node(nx, ny, node.time+1));
                }
            }
        }
        
        
        return -1;
    }
}