import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int c= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(st.nextToken());

        int w[]= new int[n];
        int v[]= new int[n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            w[i]= Integer.parseInt(st.nextToken());//비용
            v[i]= Integer.parseInt(st.nextToken());//고객 수
        }

        int dp[]= new int[c+101];

        for(int i=0; i<c+101; i++)
            dp[i]= Integer.MAX_VALUE;

        dp[0]= 0;

        for(int i=1; i<c+101; i++){
            for(int j= 0; j<n; j++){

                if(i < v[j] || dp[i- v[j]] == Integer.MAX_VALUE) continue;
                dp[i]= Math.min(dp[i], dp[i - v[j]] + w[j]);

            }
        }

        int ans= Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++)
            ans= Math.min(ans, dp[i]);

        System.out.println(ans);


    }
}