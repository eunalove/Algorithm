import java.util.*;

class Solution {
    public ArrayList solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        //첫번째 1,2,3,4,5
        //두번째 2,1,2,3,2,4,2,5
        //세번째 3,3,1,1,2,2,4,4,5,5
        
        int n= answers.length;
        
        int[] first= {1,2,3,4,5};
        int[] twice= {2,1,2,3,2,4,2,5};
        int[] third= {3,3,1,1,2,2,4,4,5,5};
        
        int ans1= 0;
        int ans2= 0;
        int ans3= 0;
        
        for(int i=0; i<n; i++){
            
            if(first[i%5]== answers[i]) ans1++; 
            if(twice[i%8]== answers[i]) ans2++;
            if(third[i%10]== answers[i]) ans3++;
            
        }
        
        int max= Math.max(ans1, Math.max(ans2, ans3));
        
        
        if(ans1==max) ans.add(1);
        if(ans2==max) ans.add(2);
        if(ans3==max) ans.add(3);
        
        Collections.sort(ans);
        
        return ans;
    }
}