class Solution {
    public int solution(int n, int k) {
        
        String s= Integer.toString(n, k);
        String[] sp= s.split("0");
        
        int ans= 0;
        for(String tmp: sp)
            if(!tmp.isEmpty() && !tmp.equals("1") && isPrime(Long.parseLong(tmp))) ans++;
            
        return ans;
    }
    
    public boolean isPrime(long n) {
	for (long i= 2; i<=Math.sqrt(n); i++) {
      if (n % i == 0) 
          return false;
	    }
	return true;
    }
    
}