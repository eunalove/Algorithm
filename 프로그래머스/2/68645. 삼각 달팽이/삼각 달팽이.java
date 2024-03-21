class Solution {
    public int[] solution(int n) {
        int[] ans = new int[(n*(n+1))/2];
        
        int[][] map= new int[n][n];
        
        int x= -1; int y= 0;
        int val= 1;
        int d= 0;
        
        //1. 아래 오른쪽 대각선 위 순서대로 돈다
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                
                if(i % 3==0) x++;
                else if(i % 3==1) y++;
                else{
                    x--;
                    y--;
                }
                
                map[x][y]= val++;
            }
        }
        
        int index= 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
             ans[index++]= map[i][j];
            }
                
        }
        
        
        return ans;
    }
}