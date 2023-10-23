/*
6과 9는 대체가능하므로 처음부터 9를 세지말고
9대신 6을 세어준다
0부터 8까지 존재하는 arr배열에 입력값을 세서 넣어주고
6이 짝수면 나누기2, 홀수면 나누기2+1을 한 다음
arr배열에서 가장 큰 값을 출력한다.
*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		String n= sc.nextLine();
		int arr[]= new int[9]; //9는 저장하지 않는다
		
		int ans= 0;
		
		for(int i=0; i<n.length(); i++) {
			
			if(n.charAt(i)- '0' == 9) {
				arr[6] += 1;
				
			}else {
			arr[n.charAt(i)- '0']+=1;
			}
		}
		
		if(arr[6]%2==0) {
			arr[6] /=2;
			
		}else{
			arr[6]= arr[6]/2 +1;
			
		};
		
		
		for(int i=0; i<arr.length; i++) {
			ans= Math.max(ans, arr[i]);
		}
		
		System.out.print(ans);
		
		
	}

}