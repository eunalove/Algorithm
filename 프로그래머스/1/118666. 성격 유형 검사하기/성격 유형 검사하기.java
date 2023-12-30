import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int type[][]= new int[5][2];
        
        /*
        1번 지표	라이언형(R), 튜브형(T)
        2번 지표	콘형(C), 프로도형(F)
        3번 지표	제이지형(J), 무지형(M)
        4번 지표	어피치형(A), 네오형(N)
        */
        
        //["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
        
        for(int i=0; i<choices.length; i++){
            if(choices[i]== 1){
                
                   if(survey[i].charAt(0)== 'R'){
                    type[1][0]+= 3;
                }else if(survey[i].charAt(0)== 'T'){
                    type[1][1]+= 3;
                }else if(survey[i].charAt(0)== 'C'){
                    type[2][0]+= 3;
                }else if(survey[i].charAt(0)== 'F'){
                    type[2][1]+= 3;
                }else if(survey[i].charAt(0)== 'J'){
                    type[3][0]+= 3;
                }else if(survey[i].charAt(0)== 'M'){
                    type[3][1]+= 3;
                }else if(survey[i].charAt(0)== 'A'){
                    type[4][0]+= 3;
                }else if(survey[i].charAt(0)== 'N'){
                    type[4][1]+= 3;
                }
                
                
                
            }else if(choices[i]== 2){
                
                if(survey[i].charAt(0)== 'R'){
                    type[1][0]+= 2;
                }else if(survey[i].charAt(0)== 'T'){
                    type[1][1]+= 2;
                }else if(survey[i].charAt(0)== 'C'){
                    type[2][0]+= 2;
                }else if(survey[i].charAt(0)== 'F'){
                    type[2][1]+= 2;
                }else if(survey[i].charAt(0)== 'J'){
                    type[3][0]+= 2;
                }else if(survey[i].charAt(0)== 'M'){
                    type[3][1]+= 2;
                }else if(survey[i].charAt(0)== 'A'){
                    type[4][0]+= 2;
                }else if(survey[i].charAt(0)== 'N'){
                    type[4][1]+= 2;
                }
                
                
                
            }else if(choices[i]== 3){
                
                if(survey[i].charAt(0)== 'R'){
                    type[1][0]+= 1;
                }else if(survey[i].charAt(0)== 'T'){
                    type[1][1]+= 1;
                }else if(survey[i].charAt(0)== 'C'){
                    type[2][0]+= 1;
                }else if(survey[i].charAt(0)== 'F'){
                    type[2][1]+= 1;
                }else if(survey[i].charAt(0)== 'J'){
                    type[3][0]+= 1;
                }else if(survey[i].charAt(0)== 'M'){
                    type[3][1]+= 1;
                }else if(survey[i].charAt(0)== 'A'){
                    type[4][0]+= 1;
                }else if(survey[i].charAt(0)== 'N'){
                    type[4][1]+= 1;
                }
                
                
                
                
            }else if(choices[i]== 4){
                
                
                
            }else if(choices[i]== 5){
                  
                 if(survey[i].charAt(1)== 'R'){
                    type[1][0]+= 1;
                }else if(survey[i].charAt(1)== 'T'){
                    type[1][1]+= 1;
                }else if(survey[i].charAt(1)== 'C'){
                    type[2][0]+= 1;
                }else if(survey[i].charAt(1)== 'F'){
                    type[2][1]+= 1;
                }else if(survey[i].charAt(1)== 'J'){
                    type[3][0]+= 1;
                }else if(survey[i].charAt(1)== 'M'){
                    type[3][1]+= 1;
                }else if(survey[i].charAt(1)== 'A'){
                    type[4][0]+= 1;
                }else if(survey[i].charAt(1)== 'N'){
                    type[4][1]+= 1;
                }
                
                
            }else if(choices[i]== 6){
                
                if(survey[i].charAt(1)== 'R'){
                    type[1][0]+= 2;
                }else if(survey[i].charAt(1)== 'T'){
                    type[1][1]+= 2;
                }else if(survey[i].charAt(1)== 'C'){
                    type[2][0]+= 2;
                }else if(survey[i].charAt(1)== 'F'){
                    type[2][1]+= 2;
                }else if(survey[i].charAt(1)== 'J'){
                    type[3][0]+= 2;
                }else if(survey[i].charAt(1)== 'M'){
                    type[3][1]+= 2;
                }else if(survey[i].charAt(1)== 'A'){
                    type[4][0]+= 2;
                }else if(survey[i].charAt(1)== 'N'){
                    type[4][1]+= 2;
                }
                     
                
            }else{
                
                if(survey[i].charAt(1)== 'R'){
                    type[1][0]+= 3;
                }else if(survey[i].charAt(1)== 'T'){
                    type[1][1]+= 3;
                }else if(survey[i].charAt(1)== 'C'){
                    type[2][0]+= 3;
                }else if(survey[i].charAt(1)== 'F'){
                    type[2][1]+= 3;
                }else if(survey[i].charAt(1)== 'J'){
                    type[3][0]+= 3;
                }else if(survey[i].charAt(1)== 'M'){
                    type[3][1]+= 3;
                }else if(survey[i].charAt(1)== 'A'){
                    type[4][0]+= 3;
                }else if(survey[i].charAt(1)== 'N'){
                    type[4][1]+= 3;
                }  
                
            }
        }
        
        if(type[1][0]>= type[1][1]) answer+="R";
        else answer+="T";
        
         if(type[2][0]>= type[2][1]) answer+="C";
        else answer+="F";
        
         if(type[3][0]>= type[3][1]) answer+="J";
        else answer+="M";
        
         if(type[4][0]>= type[4][1]) answer+="A";
        else answer+="N";
        
        return answer;
    }
}