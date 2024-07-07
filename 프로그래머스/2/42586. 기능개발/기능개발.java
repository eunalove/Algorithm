import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<int[]> queue= new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++)
            queue.add(new int[]{progresses[i], speeds[i]});
        
        int cnt= 0;
        while(!queue.isEmpty()){
            
            while(!queue.isEmpty() && queue.peek()[0] < 100){//100이하라면
                for(int[]q: queue){
                    int[] cur= queue.poll();
                    queue.add(new int[]{cur[0]+cur[1], cur[1]});
                }
            }
            
            while(!queue.isEmpty() && queue.peek()[0] >= 100){
                queue.poll();
                cnt++;
            }
            
            ans.add(cnt);
            cnt= 0;
        }
        
        return ans;
    }
}