import java.util.*;

class Solution {
    
    static int n;
    static String[] ans;
    static boolean found = false; // 정답을 찾았는지 확인하는 변수 추가

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        ans = new String[n+1];
        
        String[] list = new String[n+1];
        list[0] = "ICN";
        
        boolean[] vis = new boolean[n];
        
        Arrays.sort(tickets, (t1, t2) -> {
            if(t1[0].equals(t2[0])) {
                return t1[1].compareTo(t2[1]);
            } else {
                return t1[0].compareTo(t2[0]);
            }
        });
        
        dfs(0, "ICN", list, vis, tickets);
        return ans;
    }
    
    static void dfs(int L, String cur, String[] list, boolean[] vis, String[][] tickets){
        if(found) return; // 이미 정답을 찾았다면 더 이상 탐색하지 않음
        
        if(L == n){
            System.arraycopy(list, 0, ans, 0, n+1); // 배열 복사
            found = true; // 정답을 찾았다고 표시
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(!vis[i] && tickets[i][0].equals(cur)){
                vis[i] = true;
                list[L+1] = tickets[i][1];
                dfs(L+1, tickets[i][1], list, vis, tickets);
                vis[i] = false; // 다른 경로 탐색을 위해 방문 상태를 원래대로 돌림
            }
        }
    }
}
