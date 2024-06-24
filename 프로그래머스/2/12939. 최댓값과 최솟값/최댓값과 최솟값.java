import java.util.*;

class Solution {
    public String solution(String s) {
        String ans = "";
        
        ArrayList<Integer> list= new ArrayList<>();
        String[] ss= s.split(" ");
        
        for(String tmp:ss){
            list.add(Integer.parseInt(tmp));
        }
        Collections.sort(list);
        
        ans= list.get(0)+" "+list.get(list.size()-1);
        
        return ans;
    }
}