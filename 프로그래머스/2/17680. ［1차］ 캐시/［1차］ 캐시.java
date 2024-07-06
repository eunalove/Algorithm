import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            city = city.toUpperCase();
            if (queue.contains(city)) {
                queue.remove(city); // 히트된 항목 제거
                ans += 1; // 캐시 히트
            } else {
                ans += 5; // 캐시 미스
                if (queue.size() == cacheSize) {
                    queue.poll(); // 가장 오래된 항목 제거
                }
            }
            queue.add(city); // 새로운 항목 추가
        }
        
        return ans;
    }
}
