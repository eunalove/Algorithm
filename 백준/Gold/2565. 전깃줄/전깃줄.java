import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n= Integer.parseInt(br.readLine());

        ArrayList<int[]> line= new ArrayList<>();

        for(int i=0; i<n; i++){

            st= new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());

            line.add(new int[]{from, to});
        }

        line.sort((l1, l2)->{ return l1[0]-l2[0];});

        int[] dp= new int[line.size()];

        for(int i=0; i<line.size(); i++)
            dp[i]= 1;

        for(int i=1; i<dp.length; i++){
            for(int j=0; j< i; j++){
                if(line.get(i)[1] > line.get(j)[1])
                    dp[i]= dp[i] > dp[j] + 1? dp[i]: dp[j]+1;
            }
        }

        int max= 0;
        for(int i =0; i<dp.length; i++)
            max= max > dp[i] ? max: dp[i];


        System.out.print(n- max);


    }

}