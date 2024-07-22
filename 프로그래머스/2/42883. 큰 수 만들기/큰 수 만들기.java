
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int length = number.length();
        int newLength = length - k; // 최종적으로 만들어야 할 숫자의 길이
        char[] result = new char[newLength]; // 결과를 저장할 배열
        int top = 0; // 스택의 꼭대기를 가리키는 인덱스
        
        int maxIndex = 0;
        // 첫 번째 숫자를 찾기 위해 0부터 k번째까지 탐색
        for (int i = 0; i <= k; i++) {
            if (number.charAt(i) > number.charAt(maxIndex)) {
                maxIndex = i;
            }
        }
        
        // 첫 번째 숫자를 결과에 추가
        result[top++] = number.charAt(maxIndex);
        k -= maxIndex; // 제거할 수 있는 숫자의 수를 갱신
        
        // 남은 숫자를 처리
        for (int i = maxIndex + 1; i < length; i++) {
            char current = number.charAt(i);
            // 스택의 꼭대기 값이 현재 값보다 작고 제거할 수 있는 숫자가 남아있으면 제거
            while (top > 0 && result[top - 1] < current && k > 0) {
                top--;
                k--;
            }
            if (top < newLength) {
                result[top++] = current;
            } else {
                k--;
            }
        }
        
        return new String(result);
    }
}