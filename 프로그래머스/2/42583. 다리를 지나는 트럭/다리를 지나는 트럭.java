import java.util.*;

class Solution {  public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 총 시간
        int currentWeight = 0; // 다리 위의 현재 무게
        int index = 0; // 현재 처리 중인 트럭의 인덱스
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위의 트럭들
        
        // 다리 길이만큼 빈 공간으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            time++; // 시간 증가
            
            // 다리에서 가장 오래된 트럭이 나가면서 무게 업데이트
            currentWeight -= bridge.poll();
            
            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                bridge.add(0); // 트럭이 올라갈 수 없으면 빈 공간 추가
            }
        }
        
        // 모든 트럭이 다리를 건너고 마지막 트럭이 다리에서 나가는 데 걸리는 시간 추가
        time += bridge_length;

        return time;
    }
}