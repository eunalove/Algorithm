/*
그리디는 참 신기한 것같다
끝나는 시간을 기준으로 정렬한다는 것은 생각지도 못했다.
그리디를 증명하는 방법
명제: 현재 시간이 t라고 할 때 시작시간이 t이상인 모든 회의 중에서 가장 먼저
끝나는 회의를 택하는 것이 최적해이다.
이때 귀류법을 사용해서 명제를 증명할 수 있다
회의 A보다 늦게 끝나는 회의B를 선택했을 때 더 많은 회의를 배정할 수 있다고 가정해보자
회의 B대신 회의A를 사용해도 아무런 모순이 발생하지 않기 때문에 명제는 참이다
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		int n= Integer.parseInt(br.readLine());
		
		int[][] arr= new int[n][2]; 
		
		//10만개를 일일이 스타트 지점으로 삼는다
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		
		//끝나는 지점을 기준으로 오름차순 정렬한다
		Arrays.sort(arr, (a1, a2)->{
			return (a1[1] == a2[1]? a1[0]- a2[0]: a1[1]- a2[1]);
		});
		
		int ans= 1;
		int finish= arr[0][1];
		
		//끝나는 시간보다 같거나 큰 시작시간을 찾는다
		for(int i=1; i<n; i++) {
			
			if(arr[i][0] >= finish) {
				ans+=1;
				finish= arr[i][1]; //끝나는 시간을 갱신해준다.
				
			}	
		}
		
		//최대 회의의 갯수를 구한다.
		System.out.print(ans);
		
		
		
	}

}