import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int x = Integer.parseInt(br.readLine());
        int[] d = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;

            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
        }
        
        System.out.println(d[x]);
        
    }

}