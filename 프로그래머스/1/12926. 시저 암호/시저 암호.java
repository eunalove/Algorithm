class Solution {
    public StringBuilder solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(' ');
            } else if(c >= 'a' && c <= 'z') {
                sb.append((char)((c - 'a' + n) % 26 + 'a'));
            } else if(c >= 'A' && c <= 'Z') {
                sb.append((char)((c - 'A' + n) % 26 + 'A'));
            }
        }
        
        return sb;
    }
}
