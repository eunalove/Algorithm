import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        //알고리즘: DFS/BFS/그래프/DP/MST/위상정렬/다익스트라/유니온파인드/정렬
        //숫자 첫번째 자리, 두번째 자리, 세번째 자리... 이런식으로 정렬하기
        //근데 어떻게 자릿수를 기준으로 정렬하지?
        
        //문자열로 바꾼 다음 a+b, b+a를 비교하는 방식으로 계산가능함
        
        String[] st= new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
            st[i]= String.valueOf(numbers[i]);    
        
        Arrays.sort(st, (s1, s2)->{
            return -(s1+s2).compareTo((s2+s1));
        });
        
        if(st[0].equals("0")) return "0";
        
        StringBuilder sb= new StringBuilder();
        
        for(int i=0; i<st.length; i++)
            sb.append(st[i]);
        
        return sb.toString();
    }
}