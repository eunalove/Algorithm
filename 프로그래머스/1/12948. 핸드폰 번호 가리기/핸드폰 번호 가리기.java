class Solution {
    public StringBuilder solution(String phone_number) {
        
        int n= phone_number.length();
        
        StringBuilder sb= new StringBuilder();
        
        for(int i=1; i<=n-4; i++)
            sb.append("*");
        
        for(int i=n-4; i<n; i++)
            sb.append(phone_number.charAt(i));
                  
        return sb;
    }
}