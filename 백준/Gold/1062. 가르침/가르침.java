import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int temp_ans, ans, n, k;
    static char[] alpa;
    static char[] arr;
    static Set<Character>[] removeWords;

    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());//3
        k= Integer.parseInt(st.nextToken());//6

        //1. 만약 k가 4이하라면 0을 출력함
        if(k <= 4) ans=0;
        //2. 만약 k가 26이라면 n을 출력함
        else if(k==26) ans= n;
        else {
            String[] words = new String[n];
            removeWords = new HashSet[n];

            for (int i = 0; i < n; i++)
                removeWords[i] = new HashSet<>();

            for (int i = 0; i < n; i++)
                words[i] = br.readLine();

            //3. n개 단어를 모두 돌면서 antic을 없앰
            for (int i = 0; i < n; i++) {
                String w = words[i];
                for (int j = 4; j < w.length(); j++) {
                    char c = w.charAt(j);
                    // 'antic'에 c가 포함되어 있지 않다면 removeWords에 추가합니다.
                    if ("antic".indexOf(c) == -1) {
                        removeWords[i].add(c);
                    }
                }
            }

            //4. antic을 제외한 21개 문자들을 k-5개의 조합으로 만든다
            alpa = new char[]{'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k',
                    'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};

            arr = new char[k - 5];

            //5. 각 조합들을 모두 돌면서 최대 단어수를 찾는다
            dfs(0, 0);


        }
        System.out.print(ans);
    }

    private static void dfs(int start, int L) {

        if(L == k-5){ //1
            //k-5개의 단어 조합을 찾았다.
            //이제 이 단어들로 몇 개의 단어를 익힐 수 있는지 찾기
            findWordCnt(arr);
            ans= Math.max(temp_ans, ans);
            return;
        }

        for(int i=start; i<21; i++){

            arr[L]= alpa[i];
            dfs(i+1, L+1);

        }

    }

    private static void findWordCnt(char[] arr) {

        //arr에서 담은 문자열들로 몇 개의 글자를 읽을 수 있는지 카운팅

        temp_ans= 0;

        for(int i=0; i<n; i++){
            int cnt= removeWords[i].size();

        for(char c: removeWords[i]) {

            for (char c2 : arr) {
                if (c == c2) cnt -= 1;
            }

        }
            if (cnt == 0) temp_ans++;
        }


    }
}