class Solution {
    public int solution(int n, int[] stations, int w) {
	    int ans = 0;
	    int si = 0;
	    int position = 1;
	    while(position <= n) {
    
		    if(si < stations.length && position >= stations[si] - w) {
			    position = stations[si] + w + 1;
			    si ++;
 		    }
		    else {
			    ans += 1;
			    position += (w*2) + 1; 
		    }
	    }
	    return ans;
    }
}