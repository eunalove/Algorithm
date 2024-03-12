import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static long[][] dp; // 중복 계산을 방지하기 위해 사용하는 DP 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new long[n-1][21]; // 마지막 숫자는 결과값으로만 사용되므로, n-1까지의 숫자에 대해 0~20의 값을 갖는 경우의 수를 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 초기값 설정
        dp[0][arr[0]] = 1; // 첫 번째 숫자로 시작하는 경우의 수는 1

        for (int i = 1; i < n - 1; i++) { // 마지막 숫자 직전까지 반복
            for (int j = 0; j <= 20; j++) { // 가능한 모든 숫자에 대해
                if (dp[i-1][j] > 0) { // 이전 단계에서 j 값을 만들 수 있는 경우의 수가 있다면,
                    // + 연산
                    if (j + arr[i] <= 20)
                        dp[i][j + arr[i]] += dp[i-1][j];
                    // - 연산
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] += dp[i-1][j];
                }
            }
        }

        System.out.print(dp[n-2][arr[n-1]]); // 마지막 숫자를 결과값으로 하여 도달할 수 있는 경우의 수 출력
    }
}