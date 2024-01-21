import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        //n*n 배열을 만든다
        char[][] map= new char[n][n];
        
        //arr1, arr2를 이진수로 만들어서 배열에 넣는다
        String[] two1= new String[n];
        String[] two2= new String[n];
        
        for(int i=0; i<n; i++){
            two1[i]= String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
            two2[i]= String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
        }
        
        
        //각 배열을 돌면서 XOR연산을 해서 n*n배열에 넣는다
        //two1= 01001, 10100, 11100, 10010, 1011
        //two2= 10100, 1, 10101, 10001, 11100
        for(int i=0; i<n; i++){ //하나씩 비교한다
            
            for(int j=0; j<n; j++){ //char끼리 하나씩 비교
                
                if(two1[i].charAt(j)=='1' || two2[i].charAt(j)=='1'){
                    //둘 다 1이면 1
                    map[i][j]= '#';
                    
                }else{
                    map[i][j]= ' ';
                    
                }
            }
        }
        
        String[] answer = new String[n];
        
        //n*n배열에서 0이면 공백, 1이면 #을 answer에 넣는다
        for(int i=0; i<n; i++){
            
           answer[i]= String.valueOf(map[i]);
            
        }
      
        return answer;
    }
}