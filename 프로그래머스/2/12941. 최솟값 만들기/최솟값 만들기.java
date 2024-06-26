import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int n = A.length;
        int ans= 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<n; i++)
            ans+= A[i]* B[n- i -1];

        return ans;
    }
}