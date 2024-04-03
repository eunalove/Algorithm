import java.util.*;
import java.io.*;

class Solution {
    
    static class Node{
        
        String str; int depth;
        
        public Node(String str, int depth){
            this.str= str;
            this.depth= depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int ans = 0;
        int n= begin.length();
        
        //bfs시작
        Queue<Node> q= new ArrayDeque<Node>();
        Map<String, Integer> visited= new HashMap<String, Integer>();
        
        for(int i=0; i<words.length; i++)
            visited.put(words[i], 0);
        
        q.add(new Node(begin,0));
        visited.put(begin, 1);
        
        while(!q.isEmpty()){
        
        Node node= q.poll();
            
        String str= node.str;
        int depth= node.depth;
            
        //str이 target과 같다면 return depth;
        if(str.equals(target)) return node.depth;
            
            
        //begin문자열 숫자만큼 for문 돌리기
         for(int i=0; i<n; i++){
        
        //각 charAt에서 같은게 words에 있는지 확인
            for(int j=0; j<words.length; j++){
            boolean flag= false;
                for(int k=0; k<n; k++){
                    
                    if(i==k) continue;
                    if(str.charAt(k) != words[j].charAt(k)) {
                        flag= true;
                        break; 
                    }
                    
                }
                
                //있고 방문한 적이 없다면 q에 넣기
                //방문처리
                if(!flag && (visited.get(words[j])!=1)){
                    
                    q.add(new Node(words[j], depth+1));
                    visited.put(words[j], 1);
                    
                }
                
            
            
            }
        
        
        }
    }
    
        
        return 0;
    }
}