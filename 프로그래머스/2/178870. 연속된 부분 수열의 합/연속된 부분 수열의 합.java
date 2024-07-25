class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0; int f = 0; int n = sequence.length;
        int sum = 0; int dis = Integer.MAX_VALUE;
        int[] ans = new int[2];
        
        while (f < n) {
            sum += sequence[f];
            
            while (sum > k && s <= f) {
                sum -= sequence[s];
                s++;
            }
            
            if (sum == k && (f - s < dis)) {
                dis = f - s;
                ans = new int[]{s, f};
            }
            
            f++;
        }
        
        return ans;
    }
}
