import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb= new StringBuilder();
        String[] str= s.split(" ", -1);
        
        for(String st: str){
            
            if (st.isEmpty()) {
                sb.append(" ");
                continue;
            }
            //if(st.equals(' ')) continue;
            st= st.toLowerCase();
            
            sb.append(st.substring(0, 1).toUpperCase());
                if(st.length() > 1) sb.append(st.substring(1, st.length()));
            
            sb.append(" ");
            
            
        }
        return sb.substring(0, sb.length()-1);
    }
}