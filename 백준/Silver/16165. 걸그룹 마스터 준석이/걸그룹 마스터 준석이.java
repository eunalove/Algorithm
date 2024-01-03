/*
해시맵을 2개 사용해서
하나는 <팀이름,멤버이름 배열> 다른 하나는 <멤버이름, 팀이름>으로 만들었다.
*/
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		HashMap<String, String[]> team= new HashMap<String, String[]>();
		HashMap<String, String> girl= new HashMap<String, String>();
		
		while(n-->0){
			
			String tName= br.readLine();
			int k= Integer.parseInt(br.readLine());
			String[] arr= new String[k];
			
			while(k-->0) {
				
				String gName= br.readLine();
				girl.put(gName, tName);
				arr[k]= gName;
				
			}
			Arrays.sort(arr);
			team.put(tName, arr);
			
		}
		
		StringBuilder sb= new StringBuilder();
		
		while(m-->0) {
		
		String tmp= br.readLine();
		int pr= Integer.parseInt(br.readLine());
		if(pr==0) {
			for(String s: team.get(tmp)) sb.append(s).append("\n");
			
		}else sb.append(girl.get(tmp)).append("\n");
		
		}
		System.out.print(sb);
		
		
		
		
		
	}

}