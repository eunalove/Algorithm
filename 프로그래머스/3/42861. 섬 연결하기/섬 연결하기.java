import java.io.*;
import java.util.*;

class Solution {
    
    static int[] p;
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int w;
        
        public Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int ans = 0;
        // MST를 푸는 방법

        int v = costs.length;
        
        Edge[] edges = new Edge[v]; // costs.length로 수정
        
        for(int i = 0; i < v; i++){ // v로 변경
            
            int from = costs[i][0];
            int to = costs[i][1];
            int w = costs[i][2];
            
            edges[i] = new Edge(from, to, w);
        }
            
        // 유니온-파운드에서 사용될 배열 선언
        p = new int[n]; // n으로 수정
        
        for(int i = 0; i < n; i++) // n으로 수정
            p[i] = i;
        
        Arrays.sort(edges); // Comparator 대신 Comparable 인터페이스 구현
        
        // 같은 부모를 가지지 않으면 union 하고 비용을 더한다
        for(int i = 0; i < v; i++){ // v로 변경
            if(union(edges[i].from, edges[i].to)){
                ans += edges[i].w;
            }
        }
        
        return ans;
    }
    
    static boolean union(int a, int b){
        
        a = find(a);
        b = find(b);
        
        if(a == b) return false; // 이미 같은 집합에 속해 있는 경우
        
        p[b] = a; // b의 부모를 a로 설정
        return true;
        
    }
    
    static int find(int a){
        
        if(p[a] == a) return a;
        
        return p[a] = find(p[a]);
    }
}
