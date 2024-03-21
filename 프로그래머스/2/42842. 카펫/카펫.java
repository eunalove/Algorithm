class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        
        int l= (brown+4)/2;
        int w= brown + yellow;
        
        int x= 0; int y= 0;
        
        while(true){
            
            y++;
            x= l-y;
            
            
            if(x*y==w){
                ans[0]= x;
                ans[1]= y;
                break;
            }
            
        }
        
        return ans;
    }
}