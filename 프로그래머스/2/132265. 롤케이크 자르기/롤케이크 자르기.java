class Solution {
    public int solution(int[] topping) {
        
        int[] one= new int[10001]; //철수
        int[] two= new int[10001]; //동생
        
        int one_cnt= 0; //철수가 가진 가짓수
        int two_cnt= 0; //동생이 가진 가짓수
        
        int n= topping.length;
        int ans= 0;
        
        for(int i=0; i<n; i++){
            if(two[topping[i]] == 0) two_cnt++;
            two[topping[i]]++;
        }
        
        for(int i=0; i<n; i++){
            int cur= topping[i];
            
            if(one[cur] == 0) one_cnt++;
            one[cur]++;
            
            if(two[cur] == 1) two_cnt--;
            two[cur]--;
            
            if(one_cnt == two_cnt) ans++;
        }
        
        return ans;
        
    }
}