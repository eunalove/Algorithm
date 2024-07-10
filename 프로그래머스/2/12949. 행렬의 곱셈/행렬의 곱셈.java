class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int n= arr1.length;
        int m= arr1[0].length;
        int l= arr2[0].length;
        
        int[][] ans= new int[n][l];
        int sum= 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<l; j++){
                sum= 0;
                for(int r=0; r<m; r++)
                    sum+= arr1[i][r]* arr2[r][j];
                
                ans[i][j]= sum;
            }
           
        }
          return ans;
    }
}
