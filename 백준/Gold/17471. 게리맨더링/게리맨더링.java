import java.io.*;
import java.util.*;

public class Main {

	static int[] popul, team;
	static boolean[] visited;
	static int n, ans= Integer.MAX_VALUE;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		team = new int[n + 1];
		popul= new int[n+1];
		
		st= new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			popul[i]= Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList();
		}

		
		int cnt = 0;

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());

			while (cnt-- > 0) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 두 개의 선거구로 지역구 나누기
		// 어떻게 나눠야할까? 부분집합으로 나눠서 배열에 어떤 팀인지 저장
		makeTeam(1);
		
		if(ans== Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(ans);

	}

	static void makeTeam(int idx) {

		if (idx == n+1) {

			// 어떻게 서로 다른 두 지역으로 나누어져 있는지 연결여부를 검사할까?
			//visited를 이용해서 몇 개의 지역으로 나뉘어져 있는지 확인한다
			//인접리스트와 큐를 이용해서 인접리스트를 돌리면서 큐로 같은 지역이면 방문체크함
			
			if(check()) { //두 지역으로 나뉘어져 있다면
				int total1= 0;
				int total2= 0;
				
				for(int i=1; i<=n; i++) {
					
					if(team[i]==1) total1+= popul[i];
					else total2+= popul[i];
				}
				
				int abs = Math.abs(total1- total2);
				ans= Math.min(ans, abs);
				
			}

			return;
		}

		// 선택하는 경우
		team[idx] = 1;
		makeTeam(idx + 1);
		team[idx] = 2;
		// 선택안하는 경우
		makeTeam(idx + 1);

	}

	private static boolean check() { //두 팀이 연결되어있는지 체크하는 함수
		
		visited= new boolean[n+1];
		int cnt= 0;
		Queue<Integer> q= new ArrayDeque();
		
		for(int i=1; i<=n; i++) { //전체 인접리스트를 탐색하며
			
			if(visited[i]) continue; //이미 방문했다면 패스
			
			visited[i]= true; //방문표시
			cnt+=1; //새로운 팀 방문
			
			if(cnt > 2) return false; //1번을 초과했다는건 팀이 3개 이상으로 나뉘어졌단 뜻임
			q.add(i);
			
			while(!q.isEmpty()) {
				
				int node= q.poll();
				
				for(int element: list[node]) {
					if(visited[element] || team[node] != team[element]) continue; //이미 방문했거나 같은 팀이 아니면 패쓰
					visited[element]= true;
					q.add(element);
					
				}
				
			}
		}
		
		return true;
	}

}