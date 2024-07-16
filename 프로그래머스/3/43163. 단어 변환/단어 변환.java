import java.util.*;

class Solution {
    
    static class Node{
        String str;
        int cnt;
        
        public Node(String str, int cnt){
            this.str= str;
            this.cnt= cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
    
        Queue<Node> q= new ArrayDeque<>();
        Set<String> vis= new HashSet<>();
        vis.add(begin);
        
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()){
            
            Node cur= q.poll();
            
            if(cur.str.equals(target)) return cur.cnt;
            
                for(String word: words){
            
                    int cnt= 0;        
                    for(int i=0; i<word.length(); i++){
                        
                       if(cur.str.charAt(i) != word.charAt(i)) cnt++;
                    }
                    
                    if(cnt == 1 && !vis.contains(word)){
                        vis.add(word);
                        q.add(new Node(word, cur.cnt+1));
                        
                    }
            }
            
        }
        
        return 0;
        
    }
}