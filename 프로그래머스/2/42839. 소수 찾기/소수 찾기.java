class Solution {
    static int size =10000000;
    static boolean isPrime[] = new boolean[size + 1];
    static boolean chk[] = new boolean[size + 1];
    static int ans;
    
    static int n;
    static boolean[] visited;
    static String nums;
    
    public int solution(String numbers) {
        n= numbers.length();
        visited= new boolean[n];
        nums= numbers;
        
        isPrime[0] = isPrime[1] = true;
        for(int i = 2; i * i <= size; i++) {
            if(isPrime[i]) continue;
            for(int j = i * i; j <= size; j += i)
                isPrime[j] = true;
        }
        
        //순열 만들기
        //011로 만들 수 있는 모든 숫자조합
        dfs(0, 0);
        
        
        return ans;
    }
    
    static void dfs(int L, int num){
        
        if(!isPrime[num] && !chk[num]) {
            chk[num] = true;
            ans++;
        }
        
        for(int i=0; i<n; i++){
            
            if(!visited[i]){
                
                visited[i]= true;
                dfs(L+1, num*10+ nums.charAt(i)- '0');
                visited[i]= false;
                
            }
        }
        
    }
}