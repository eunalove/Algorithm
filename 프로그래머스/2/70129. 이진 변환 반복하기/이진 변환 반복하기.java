class Solution {
    public int[] solution(String s) {
        
        int change_cnt= 0; int remove_zero= 0;
        int len= 0;
        int i=0;
        while(true){
            len= 0;
            if(s.equals("1")) break; //01110 11 10
            change_cnt++; //1 2 3
            char[] c= s.toCharArray();
        
                for(char c1: c){
                    if(c1 == '0'){
                        remove_zero++; //2 2 3
                        continue;
                    }
                    len++; //3 2 2
                }
        
            
            s= Integer.toBinaryString(len);
        }
        
        int[] ans= {change_cnt, remove_zero};
        return ans;
    }
}