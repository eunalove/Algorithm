class Solution {
    public int solution(int[][] sizes) {
        
        //좀 그리디 느낌나는데, 
        //어쨌거나 한 쪽은 무조건 제일 긴 길이여야한다
        //그러므로 둘 중 큰 쪽은 가로로 고정시키고 세로는 둘 중 작은 쪽으로 고정시키기
        //그럼 가로, 세로 중에서 가장 큰 것들끼리 곱하면 됨
        
        int w= 0, h= 0;
        int n= sizes.length;
        
        for(int i=0; i<n; i++){
            
            int max = Math.max(sizes[i][0], sizes[i][1]);
            w = Math.max(max, w);
            
            int min = Math.min(sizes[i][0], sizes[i][1]);
            h = Math.max(min, h);
            
            
            
        }
        
        return w*h;
        
        
        
        
        
        
    }
}