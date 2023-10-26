import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, min= Integer.MAX_VALUE, ans= Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Integer[]> list_chicken, list_home;
	static boolean[] visited;
	static int[] combi;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		list_chicken = new ArrayList<Integer[]>();
		list_home = new ArrayList<Integer[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					list_home.add(new Integer[] { i - 1, j - 1 });
				} else if (map[i][j] == 2) {
					list_chicken.add(new Integer[] { i - 1, j - 1 });
				}
			}
		}

		visited = new boolean[list_chicken.size()];
		combi = new int[m];

		// 완전 탐색으로 풀자
		// 그럼 치킨집중에서 m개를 고르고 그 중에서 다른 집이랑 최솟값을 구해야겠네
		// 치킨집을 리스트에 넣은 다음 그 중 m개를 고르자

		// 집합으로 ㄱㄱ
		dfs(0, 0);
		
		System.out.print(ans);

	}

	private static void dfs(int L, int start) {

		if (L == m) {
			chicken(combi);
			return;
		}

		for (int i = start; i < list_chicken.size(); i++) {
			combi[L] = i;
			dfs(L + 1, i + 1);
		}
	}

	static void chicken(int[] combi) {
		// 치킨집 중에서 뭘 고를지 결정했기 때문에
		// 모든 집을 순환하면서 가장 거리가 작은 치킨집을 찾는다

		int total= 0;
		for (int i = 0; i < list_home.size(); i++) {
			int dis= Integer.MAX_VALUE;
			min= Integer.MAX_VALUE;
			for(int j: combi) {

				dis= Math.abs(list_home.get(i)[0]- list_chicken.get(j)[0])+
						Math.abs(list_home.get(i)[1]- list_chicken.get(j)[1]);
				
				min= Math.min(min, dis);
			}
			total+= min;
			
		}
		
		
		ans= Math.min(total, ans);
		

	}

}