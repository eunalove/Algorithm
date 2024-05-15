import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int n=0;
            
        for(int[] comm: commands){
            
            int i= comm[0]; //4
            int j= comm[1]; //4
            int k= comm[2]; //1
            
            int cnt=0;
            int[] arr= new int[j-i+1];
            int cnt2= 0;
            for(int tmp= i-1; tmp<=j-1; tmp++){//3-3
                arr[cnt2++]= array[tmp];
            }
            Arrays.sort(arr);
            ans[n++]= arr[k-1];
        }
        return ans;
    }
}