import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        for (String city : cities) {
            city = city.toUpperCase();
            if (queue.contains(city)) {
                queue.remove(city);
                queue.add(city);
                ans += 1;  // Cache hit
            } else {
                if (queue.size() == cacheSize && cacheSize > 0) {
                    queue.poll();
                }
                if (cacheSize > 0) {
                    queue.add(city);
                }
                ans += 5;  // Cache miss
            }
        }
        
        return ans;
    }
}
