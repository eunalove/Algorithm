import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  // 현재 논문보다 많이 인용된 논문의 수
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}
