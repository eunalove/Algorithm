import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int n, m;
    static ArrayList<int[]> list;
    static Queue<int[]> virus;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = Integer.MIN_VALUE; // 최대 안전 영역 크기를 구하기 위해 초기값을 설정

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virus = new ArrayDeque<>();

        map = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    list.add(new int[]{i, j});
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int L, int start) {

        if (L == 3) {
            // 벽을 3개 세웠을 때 안전 영역 크기 계산
            bfs();
            return;
        }

        for (int i = start; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            // 벽을 세우는 경우
            map[x][y] = 1;
            dfs(L + 1, i + 1);
            map[x][y] = 0; // 백트래킹
        }
    }

    private static void bfs() {
        // 바이러스를 퍼뜨리는 BFS 함수

        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempMap[i] = Arrays.copyOf(map[i], m);
        }

        int cnt = 0; // 안전 영역 크기 카운트

        Queue<int[]> queue = new LinkedList<>(virus);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tempMap[nx][ny] == 0) {
                    // 안전 영역인 경우 바이러스 퍼뜨림
                    tempMap[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 크기 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt); // 최대 안전 영역 크기 갱신
    }
}