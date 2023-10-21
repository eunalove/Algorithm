import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {

    static long[] map1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int ans = 0;

            HashSet<Integer> set = new HashSet<Integer>();

            
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            
            for (int j = 0; j < m; j++) {
                int cd = (Integer.parseInt(br.readLine()));
                if (set.contains(cd)) {
                    ans += 1;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);

    }
}