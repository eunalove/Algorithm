import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();

        char[][] array = new char[N][M];

        //입력값 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                array[i][j] = line.charAt(j);
            }
        }

        //1로만 움직이기
        System.out.println(bfs(N,M,array));


}

    static int bfs(int N, int M, char[][] array) {

        //위에서부터 반시계 방향으로 탐색
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        boolean[][] visited = new boolean[N][M];


        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {

            Node node = q.poll();
            if (node.x == N - 1 && node.y == M - 1)
                return node.cost;

            for (int i = 0; i < 4; i++) {

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (array[nx][ny] == '1') {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Node(nx, ny, node.cost + 1));
                        }
                    }
                }

            }

        }
        return -1;
    }


}


    class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
