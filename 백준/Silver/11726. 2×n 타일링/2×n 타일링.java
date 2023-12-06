import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();


        long[] dp= new long[N+2];

        dp[0]= 0;
        dp[1]= 1;
        dp[2] =2;

        for(int i=3; i<N+1; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;

        }


        System.out.print(dp[N]);
    }

}
