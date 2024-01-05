/*
compareTo()는 문자열 하나하나를 사전순으로 비교함
매번 람다식만 쓰다가 까먹음...
음수면 작고 ==면 같고 양수면 크다
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        String str = null;
        
        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(S.compareTo(time) >= 0) {
                before.add(name);
            }else if(E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                after.add(name);
            }
        }

        int ans = 0;
        for(String name : nameSet) {
            if(before.contains(name) && after.contains(name)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}