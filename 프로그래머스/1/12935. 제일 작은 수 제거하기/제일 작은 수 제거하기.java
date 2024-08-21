class Solution {
    public int[] solution(int[] arr) {
        
        int n= arr.length;
        
        int[] ans= new int[n-1];
        
        if(n==1) return new int[]{-1};
        else{
            int min_idx= 0;
            
            for(int i=0; i<n; i++)
                min_idx= arr[min_idx]< arr[i]? min_idx: i;
            
            int cnt= 0;
            for(int i=0; i<n; i++){
                if(i == min_idx) continue;
                ans[cnt++]= arr[i];
            }
        }
        
        return ans;
    }
}