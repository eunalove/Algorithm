//https://fbtmdwhd33.tistory.com/60 참조
//평범한 배낭이랑 아예 같은 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int[] w= new int[n+1];
        int[] v= new int[n+1];

        for(int i=1; i<=n; i++){
            st= new StringTokenizer(br.readLine());
            w[i]= Integer.parseInt(st.nextToken());
            v[i]= Integer.parseInt(st.nextToken());
        }

        int[][] dp= new int[n+1][k+1];

        for(int i=1; i<= n; i++){//아이템 갯수만큼 돌린다
            for(int j= 1; j<=k; j++){//가질 수 있는 value만큼 돌린다

                dp[i][j]= dp[i-1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
                if(j >= w[i])  // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                    // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                    dp[i][j]= Math.max(dp[i][j], dp[i-1][j-w[i]]+ v[i]);

            }

        }

        System.out.print(dp[n][k]);

    }
}