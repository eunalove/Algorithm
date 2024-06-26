import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer, Integer> map= new HashMap();
        
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        int n= nums.length/2;
        
        if(n <= map.size()) return n;
        else return map.size();
        
    }
}