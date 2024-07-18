class Solution {
    public int solution(String dirs) {
        
        int[][] map = new int[11][11];
        boolean[][][] vis= new boolean[11][11][4];
        int ans= 0;
        
        int x= 5; int y= 5;
        
        for(int i=0; i<dirs.length(); i++){
        
            switch(dirs.charAt(i)){
            
                case 'U': if(x-1 >= 0){
                    if(!vis[x][y][0] && !vis[x-1][y][1])ans++;
                    vis[x][y][0]= true;
                    x-=1;
                    vis[x][y][1]= true;
                }
                    break;
                    
                case 'D': if(x+1 <= 10){
                    if(!vis[x][y][1] && !vis[x+1][y][0])ans++;
                    vis[x][y][1]= true;
                    x+=1;
                    vis[x][y][0]= true;
                }
                    break;
                    
                case 'R': if(y+1 <= 10){
                    if(!vis[x][y][2] && !vis[x][y+1][3])ans++;
                    vis[x][y][2]= true;
                    y+=1;
                    vis[x][y][3]= true;
                }
                    break;
            
                case 'L':if(y-1 >= 0){
                    if(!vis[x][y][3] && !vis[x][y-1][2])ans++;
                    vis[x][y][3]= true;
                    y-=1;
                    vis[x][y][2]= true;
                }
                    
            }
        
        }
        return ans;
    }
}