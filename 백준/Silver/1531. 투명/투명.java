import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int[][] map = new int[101][101];
		int ans=0;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			int x1= Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			int x2= Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			
			for(int j= x1; j<x2+1; j++) {
				for(int k= y1; k<y2+1; k++) {
					
					map[j][k] += 1;
				}
			}	
			}
			
			for(int i=1; i<101; i++) {
				for(int j=1; j<101; j++) {
					if(map[i][j] > m) ans+=1;
				}
			}
			
			System.out.print(ans);
			
			
		}
		
		
	}