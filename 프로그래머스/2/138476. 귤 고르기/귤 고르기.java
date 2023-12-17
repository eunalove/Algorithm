import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        //map으로 귤 크기를 세고 그 중에서 갯수가 작은 순서대로 없애버리기
        
        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            int element= tangerine[i];
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        
        int[][] arr= new int[map.size()][2];
        
        int cnt= 0;
        //value값 크기가 큰 순서대로 정렬하기
        for(Entry<Integer, Integer> entry: map.entrySet()){
            
            arr[cnt][0] = entry.getKey();
            arr[cnt][1] = entry.getValue();
            cnt+=1;
        }
        
        Arrays.sort(arr, (a1, a2)->{
            return -(a1[1]- a2[1]);
        });
            
        int sum= 0;
        int answer = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i][1];
            answer+=1;
            if(sum >= k) break;
        }    
        
        
        return answer;
    }
}