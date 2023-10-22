import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		int[] arr= new int[n];
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		int first= arr[0];
		
		arr[0]= -1;
		
		int ans =0;
		boolean flag= false;
		
		while(true) {
		
		flag= false;
		Arrays.sort(arr);
		
		if(first <= arr[arr.length-1]) {
			flag= true;
			first+=1;
			ans+=1;
			arr[arr.length-1]-=1;
			
		}
		
		if(!flag) {
			break;
		}
		}
		
		System.out.println(ans);
		
	}
}