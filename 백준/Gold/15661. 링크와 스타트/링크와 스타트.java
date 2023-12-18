import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, ans= Integer.MAX_VALUE;
	static int[] team;
	static int[] ability;
	static int[][] map;
	static ArrayList<Integer> team1List;
	static ArrayList<Integer> team2List;
	static int sumTeam1;
	static int sumTeam2;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		team= new int[n+1];
		ability= new int[2];
		StringTokenizer st=null;
		
		map= new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		//두 팀으로 나눈다. 단, 최소 한 명이상이여야함
		makeTeam(1);
		
		
		//각 팀의 능력치를 구한다
		System.out.print(ans);
		
		
	}

	 static void makeTeam(int idx) {
		 
		 if(idx == n+1) {
			 
			 //각 팀의 능력치 구하기
			 simul();
			 
			 return;
		 }
		 
		 //1번팀인 경우
		 team[idx]= 1;
		 makeTeam(idx+1);
		 
		 team[idx]= 2;
		 //2번팀인 경우
		 makeTeam(idx+1);
		
	}

	 static void simul() {
		 
		 //순열 이용해서 결과 사이즈가 2인 모든 경우의 수 구하기
		 //한 팀의 갯수가 0인 경우는 패쓰
		 //한 팀의 갯수가 1인 경우도 패쓰, 다른 팀은 센다
		 
		 team1List= new ArrayList<Integer>();
		 team2List= new ArrayList<Integer>();
		 
		 sumTeam1= 0;
		 sumTeam2= 0;
		 
		 for(int i=1; i<=n; i++) {
			 if(team[i]==1) team1List.add(i);
			 else team2List.add(i);
		 }
		 
		 if(team1List.size()== 0 || team2List.size()== 0) return;
		 
		 if(team1List.size()== 1) {
			 dfs2(0);
		 }else if(team2List.size()== 1) {
			 dfs1(0);
		 }else {
			 dfs1(0);
			 dfs2(0);	 
		 }
		 
		 int tmp= Math.abs(sumTeam1- sumTeam2);
		 ans= Math.min(ans, tmp);
		
	}

	 static void dfs1(int idx) {
		 
		 
		 if(idx== 2) {
			 sumTeam1+= map[ability[0]][ability[1]];
			 return;
		 }
		 
		 for(int x: team1List) {
			 ability[idx]= x;
			 dfs1(idx+1);
		 } 
		
	}
	 
	 
static void dfs2(int idx) {
		 
		 
		 if(idx== 2) {
			 sumTeam2+= map[ability[0]][ability[1]];
			 return;
		 }
		 
		 for(int x: team2List) {
			 ability[idx]= x;
			 dfs2(idx+1);
		 } 
		
	}

}