import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		StringBuilder sb=new StringBuilder();

		for(int tc=1; tc<11; tc++) {
			
			int ans= 0;
			br.readLine();

			map= new int[100][100];

			for(int i=0; i<100; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}

			//세로로 본다
			//세로로 가면서 빨간색이랑 파란색이 한쌍이 된다면 ans+=1;한다
			
			int red= 0;
			int blue= 0;
			
			for(int i=0; i<100; i++) { //1이 빨강, 2가 파랑
				 red= 0;
				 blue= 0;
				for(int j=0; j<100; j++) { //세로로 보면서 진행
					
					if(map[j][i]== 1) { //빨강을 만났을 때
						red=1;
						
					}else if(map[j][i]== 2) { //블루를 만났을 때
						blue=1;
						if(red== 1) { //이미 블루가 있다면 둘 다 초기화하고 정답+=1
							red= 0;
							blue= 0;
							ans+=1;
						}
					}
					
					
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.print(sb);
	}
}