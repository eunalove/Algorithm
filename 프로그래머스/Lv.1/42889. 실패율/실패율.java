import java.util.*;

//실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//입력: 전체 스테이지 갯수 N, 멈춰있는 스테이지 번호 배열 stages
//조건: 실패율이 같다면 작은 번호의 스테이지, 스테이지 도달한 유자가 없다면 실패율은 0
//출력: 실패율 내림차순으로 스테이지의 번호가 담긴 배열

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] player= new int[N+2]; //0-6
        int userAmount= stages.length;
        
        for(int i=0; i<userAmount; i++){
        //각 스테이지별 멈춰있는 플레이어 수를 구한다.
            player[stages[i]]++;
            
        }
        
        int challenge= 0;
         //첫번째 인자는 실패율, 두번째는 번호(1-N+1)
        double[][] fail= new double[N+1][2];
        
        
        //실패율을 구해서 이차배열에 넣는다
        for(int i=1; i<N+1; i++){ //1-5
            challenge= userAmount- player[i-1];
            if(challenge<= 0){
                fail[i][0]= 0;
                fail[i][1]= i;
                continue;
            }
            fail[i][0]=  (double)player[i]/challenge;
            fail[i][1]= i;
            
            userAmount-= player[i-1];
        }
        
        //이차배열을 정렬한다
        Arrays.sort(fail, 1, N+1, (f1, f2)->{
            
           if(f1[0]==f2[0]){
               return Double.compare(f1[1], f2[1]);
        }else{
               return Double.compare(f2[0], f1[0]);
           }
        });
        
        int[] answer= new int[N];
        //이차배열의 두번째만 리턴한다.
        for(int i=1; i<N+1; i++){ //1-5
            answer[i-1]= (int)fail[i][1];
        }
        
        return answer;
    }
}