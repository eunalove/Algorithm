class Solution {
    static int[][] map;
    static int zero;
    static int one;
    
    public int[] solution(int[][] arr) {
        int[] ans= new int[2];
        int n= arr.length;
        map= new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j]= arr[i][j];
            }
        }
        
        dfs(0,0,n); //0,0,4
        
        ans[0]= zero;
        ans[1]= one;
        return ans;
    }
    
    void dfs(int x, int y, int n){
        
        int isZero= 0;
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                isZero+= map[i][j];
            }
        }
        
        
        if(isZero==0) {
            zero++;
            return; //다음으로 넘어가기
        }
        
        if(isZero==n*n) {
            one++;
            return; //다음으로 넘어가기
        }
        
        dfs(x,y,n/2); //범위를 더 줄이기 0,0,2 0,0,1 
        dfs(x,y+n/2,n/2); //범위를 더 줄이기 0,1,1
        dfs(x+n/2,y,n/2); //범위를 더 줄이기 1,0,1
        dfs(x+n/2,y+n/2,n/2); //범위를 더 줄이기 1,1,1
        
    }
}