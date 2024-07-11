import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static char[] words= {'A','E','I','O','U'};
    static int cnt, ans= -1;
    
    public int solution(String word) {
        
        dfs(0, "", word);
        return ans -1;
    }
    
    static void dfs(int L, String cur, String word){
        if(ans>0) return;
        if(L>5) return;
        cnt++;
        
        if(cur.equals(word)) ans= cnt;
        
        for(int i=0; i<5; i++){
            
            dfs(L+1, cur+ words[i], word);
            
        }
    }
}