import java.io.*;
import java.util.*;

class Solution {
    
    static int[] p;
    
    static class Edge{
        int from;
        int to;
        int w;
        
        public Edge(int from, int to, int w){
            this.from= from;
            this.to= to;
            this.w= w;
        }
        
    }
    
    public int solution(int n, int[][] costs) {
        int v= costs.length;
        
        Edge[] edge= new Edge[v];
        
        
        //cost저장하기
        for(int i=0; i<v; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int w = costs[i][2];
            
            edge[i]= new Edge(from, to, w);
        }
        
        //정렬하기 다익스트라는 시작점이 정해져있지만 MST는 직접 찾아야함
        Arrays.sort(edge, (e1, e2)->{
            return e1.w- e2.w;
        });
        
        int ans=0;
        
        //유니온 파인드에 쓰일 p[] 초기값
        p= new int[n];
        
        for(int i=0; i<n; i++)
            p[i]= i;
        
        int cnt= 1;
        //같은 부모인지 찾기
        for(int i=0; i<edge.length; i++){
            
            //같으면 ans에 w더하기
            if(!union(edge[i].from, edge[i].to)) {
                cnt++;
                ans+= edge[i].w;
                if(cnt == n) return ans;
            }
            
        }
        
        return ans;
        
        
    }
    
    static boolean union(int a, int b){//두 매개변수의 부모가 같은지 다른지 확인하는 함수
        
        a= find(a);//a의 부모를 찾는다
        b= find(b);//b의 부모를 찾는다
        
        if(a==b) return true;//같으면 true를 리턴한다
        
        //아니면 b의 부모를 a로 옮긴다
        p[b] =a;
        
        //false를 리턴한다
        return false;
    }
    
    
    static int find(int a){// a의 부모를 알려주는 함수
        
        if(p[a] == a) return a;
        
        return p[a]= find(p[a]);
        
    }
    
    
}
