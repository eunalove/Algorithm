import java.util.*;

class Solution {
    public StringBuilder solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list= new ArrayList<>();
        
        for(int i=0; i<t*t; i++){
            list.add(Integer.toString(i, n).toUpperCase());
        }
            
        
        int idx= 0;
        for(int i=0; i<list.size(); i++){
            
            String s= list.get(i);
            for(int j=0; j<s.length(); j++){
                idx++;
                if((idx-p)%m ==0) sb.append(s.charAt(j));
                if(sb.length() == t) return sb;
            }
        }
        
        return sb;
    }
}