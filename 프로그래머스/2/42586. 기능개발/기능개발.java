import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        //리스트에 progress, speeds를 넣은 뒤 progress에 speeds를 더해준다
        //가장 앞에 있는 원소가 100을 넘으면, 100이 넘는 원소들을 다 빼내고
        //빼낸게 몇개인지를 ans에 저장
        
        ArrayList<int[]> pro = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++)
            pro.add(new int[]{progresses[i], speeds[i]});
        
        while(!pro.isEmpty()){
            
            for(int i=0; i<pro.size(); i++){
                pro.get(i)[0] += pro.get(i)[1];
            }
           
            if(pro.get(0)[0] >= 100){ //이미 완료했다면
    
                int cnt= 0;
                
                while(!pro.isEmpty() && pro.get(0)[0] >= 100){
                    cnt++;
                    pro.remove(0);
                }
                
                ans.add(cnt);
            }
        }
        
        return ans;
    }
}