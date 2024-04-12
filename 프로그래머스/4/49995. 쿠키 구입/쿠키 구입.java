public class Solution {
    public int solution(int[] cookie) {
        int maxCookie = 0; // 한 명의 아들에게 줄 수 있는 가장 많은 과자 수

        for (int m = 0; m < cookie.length - 1; m++) {
            int leftSum = cookie[m];
            int rightSum = cookie[m + 1];
            int leftIndex = m;
            int rightIndex = m + 1;

            while (true) {
                if (leftSum == rightSum) { // 두 아들에게 줄 과자 수가 같다면
                    maxCookie = Math.max(maxCookie, leftSum); // 최대값 업데이트
                }
                
                // 왼쪽 또는 오른쪽으로 포인터를 이동할 수 있는지 확인하고, 과자 수를 조정
                if (leftIndex > 0 && leftSum <= rightSum) {
                    leftIndex--;
                    leftSum += cookie[leftIndex];
                } else if (rightIndex < cookie.length - 1 && rightSum <= leftSum) {
                    rightIndex++;
                    rightSum += cookie[rightIndex];
                } else {
                    break; // 더 이상 이동할 수 없으면 반복 종료
                }
            }
        }

        return maxCookie;
    }
}
