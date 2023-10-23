import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		String n= sc.nextLine();
		char[] c= n.toCharArray();
		
		int arr[]= new int[9]; //9는 저장하지 않는다
		
		int ans= 0;
		
		for(int i=0; i<c.length; i++) {
			
			if(c[i]- '0' == 9) {
				arr[6] += 1;
				
			}else {
			arr[c[i]- '0']+=1;
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