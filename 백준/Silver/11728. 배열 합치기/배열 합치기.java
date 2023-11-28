import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] a = new int[A];
        int[] b = new int[B];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < A; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < B; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while(i < A && j < B){
            sb.append(a[i] <= b[j] ? a[i++] : b[j++]).append(" ");
        }
        
        // 아직 남아 있는 내역이 있을 수 있으므로 추가
        while(i < A) sb.append(a[i++]).append(" ");
        while(j < B) sb.append(b[j++]).append(" ");
        System.out.println(sb); // 출력
    }
}