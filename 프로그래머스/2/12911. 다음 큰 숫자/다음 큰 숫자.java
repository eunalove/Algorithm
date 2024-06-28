class Solution {
    public int solution(int n) {
        String s= Integer.toBinaryString(n);
        int len= 0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i) == '1') len++;
        
        for(int i=n+1; i<1000000; i++){
            
            String s2= Integer.toBinaryString(i);
            int len2= 0;
            for(int j=0; j<s2.length(); j++)
                if(s2.charAt(j) == '1') len2++;
            
            if(len == len2) return i;
        }
        
        return -1;
    }
}