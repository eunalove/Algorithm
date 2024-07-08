import java.util.*;

class Solution {
    public int[] solution(String s) {
        StringTokenizer st= new StringTokenizer(s, "{},", true);
        Map<Integer, Integer> map= new HashMap<>();
        
        while(st.hasMoreTokens()){
            String next= st.nextToken();
            if(next.equals("{") || next.equals("}") || next.equals(",")) continue;
            map.put(Integer.parseInt(next), map.getOrDefault(Integer.parseInt(next), 0) +1);
            
        }
        
        
        ArrayList<Integer> list= new ArrayList<>(map.keySet());
        
        Collections.sort(list, (l1, l2) -> {return map.get(l2) - map.get(l1);});
        
        int[] ans= new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
            ans[i]= list.get(i);
            
        return ans;
    }
}