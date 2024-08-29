import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int switchCount = sc.nextInt();
        int[] array = new int[switchCount];
        for(int i=0; i<switchCount; i++){
            array[i] = sc.nextInt();
        }

        int personCount = sc.nextInt();
        for(int i=0; i<personCount; i++) {
            int sex = sc.nextInt();
            int recieveSwitchStaus = sc.nextInt();

            if(sex == 1){ //남학생인 경우
                for(int j=recieveSwitchStaus-1; j<switchCount; j+=recieveSwitchStaus){
                    //1부터 8까지, 2랑 5를 바꿔야겠네
                    //4라면 3,7
                   // array[j]= (array[j]+1)%2;
                    if(array[j]==0){
                        array[j] = 1;
                    }else{
                        array[j] = 0;
                    }
                }
            }else { //여학생인 경우
                //가운데를 중심으로 양 옆이 같은 데까지!

                //일단 본인부터 바꿔줌
                if(array[recieveSwitchStaus-1] ==0){
                    array[recieveSwitchStaus-1] =1;
                }else{
                    array[recieveSwitchStaus-1] =0;
                }

                int left= recieveSwitchStaus-1; //2
                int right = recieveSwitchStaus+1; //4

                while(true) {

                    if(left>0 && right<=switchCount) {
                        if (array[left - 1] == array[right - 1]) { //[1]==[3]
                            if (array[left - 1] == 0) {
                                array[left - 1] = 1;
                                array[right - 1] = 1;
                            } else {
                                array[left - 1] = 0;
                                array[right - 1] = 0;
                            }

                            left = left - 1; //1
                            right = right + 1; //5

                        } else {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }

        for(int i =0; i< array.length; i++){
            if((i!=0)&&((i%20)==0)){
                System.out.println();
            }
            System.out.print(array[i]+" ");
        }


    }
}
