import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> set= new HashSet<>();
        String str=""; char last=words[0].charAt(0); //t
        int val1= 0; int val2= 0;
        
        for(int i=0; i<words.length; i++){
            
            str= words[i];//now
           
            if(set.contains(str) || str.charAt(0) != last) return new int[]{(i % n) + 1, (i / n) + 1};
            set.add(str);//now
            
            last= str.charAt(str.length()- 1); //r
        }
        
        return new int[]{0,0};
    }
}