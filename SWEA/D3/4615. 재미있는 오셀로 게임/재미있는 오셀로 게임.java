
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb=new StringBuilder();
	static int n, count, blackCnt, whiteCnt;
	static int[][] map;
	static int[] dx= {-1,-1, 0, 1, 1, 1, 0, -1}; //위에서부터 시계방향
	static int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int T= Integer.parseInt(br.readLine());

		StringTokenizer st= null;

		for(int tc=1; tc<T+1; tc++) {
			
			blackCnt= 0;
			whiteCnt= 0;

			st= new StringTokenizer(br.readLine());

			n= Integer.parseInt(st.nextToken());
			count= Integer.parseInt(st.nextToken());
			map= new int[n][n];

			//x,y 반대인거 기억하기, 백돌이 1이고 흑돌이 2임
			//그리고 1부터 시작하는거 기억하기
			//처음 세팅해주기
			map[n/2-1][n/2-1]= 2;
			map[n/2][n/2-1]= 1;
			map[n/2-1][n/2]= 1;
			map[n/2][n/2]= 2;


			int x;
			int y;
			int bwStone;

			for(int i=0; i<count; i++) {
				st= new StringTokenizer(br.readLine());

				y= Integer.parseInt(st.nextToken())-1;
				x= Integer.parseInt(st.nextToken())-1;
				bwStone= Integer.parseInt(st.nextToken());

				map[x][y]= bwStone;

				simul(x,y,bwStone);

			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1) {
						blackCnt+=1;
					}else if(map[i][j] == 2) {
						whiteCnt+=1;
					}
					
				}
			}
			
			sb.append("#").append(tc).append(" ").append(blackCnt).append(" ").append(whiteCnt).append("\n");
			
		}
		
		System.out.print(sb);
	}

	private static void simul(int x, int y, int bwStone) {
		
		int start_x= x;
		int start_y= y;

		int nx= 0, bx= 0;
		int ny= 0, by= 0;

		//상하좌우대각선 총 8방향으로 쭉 가서 검은색 혹은 흰색 돌이 있는지 찾는다
		for(int i=0; i<8; i++) {

			int temp_x= start_x;
			int temp_y= start_y;
			
			while(true) {

				nx= temp_x+ dx[i];
				ny= temp_y+ dy[i];

				if(nx<0 || ny<0 || nx>=n || ny>= n || map[nx][ny]== 0) break;

				if(map[nx][ny] == bwStone) {

					while(true) {

						bx= nx- dx[i];
						by= ny- dy[i];
						

						if(bx== start_x && by== start_y) break;

						map[bx][by]= bwStone;
						
						nx= bx;
						ny= by;

					}

					break;

				}
				
				temp_x= nx;
				temp_y= ny;
				
			}
		}
	}
}


