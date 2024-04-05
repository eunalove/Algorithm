import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] oper) {
        
        //1. 최소힙, 최대힙 생성
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 'I'이면 추가, 'D'면 힙에서 삭제
        for(String s: oper){
            char c = s.charAt(0);
            int cnt;
            if (s.length() > 2) { // 'I' 또는 'D' 이후의 숫자 처리
                cnt = Integer.parseInt(s.substring(2));
            } else {
                cnt = 0;
            }
            
            switch(c){
                case 'I':
                    list.add(cnt);
                    break; // case 'I'에서 break가 누락되었습니다.
                
                case 'D':
                    if(!list.isEmpty()) {
                        Collections.sort(list); // 리스트 정렬
                        if(cnt == -1){
                            list.remove(0); // 최솟값 삭제   
                        } else {
                            list.remove(list.size() - 1); // 최댓값 삭제
                        }
                    }
                    break; // 이 break도 필요합니다.
            }
        }
        
        int[] ans = new int[2];
        
        if(list.isEmpty()){
            ans[0] = 0;
            ans[1] = 0;
        }
        else{
            Collections.sort(list); // 결과 출력 전 정렬
            ans[0] = list.get(list.size() - 1); // 최댓값
            ans[1] = list.get(0); // 최솟값
        }
        
        return ans;
    }
}
