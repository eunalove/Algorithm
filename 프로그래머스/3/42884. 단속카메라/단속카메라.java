import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        int ans= 1;
        
        Arrays.sort(routes, (a, b) ->{
            return a[1]- b[1];
        });
        
        int n= routes.length;
        
        int max= routes[0][1];
        
        for(int i=1; i<n; i++){
            if(max < routes[i][0]){
            max= routes[i][1];
            ans++;
            }
        }
        
        return ans;
        
    }
}