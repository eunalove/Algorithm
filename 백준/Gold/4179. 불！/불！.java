import java.io.*;
import java.util.*;

class Node {
    int x, y, time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] maze = new char[n][m];
        Queue<Node> fireQ = new ArrayDeque<>();
        Queue<Node> personQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'J') {
                    personQ.add(new Node(i, j, 1));
                } else if (maze[i][j] == 'F') {
                    fireQ.add(new Node(i, j, 0));
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!personQ.isEmpty()) {
            // 불을 먼저 움직입니다.
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                Node fire = fireQ.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = fire.x + dx[d];
                    int ny = fire.y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == '.') {
                        maze[nx][ny] = 'F';
                        fireQ.add(new Node(nx, ny, fire.time + 1));
                    }
                }
            }

            // 사람을 움직입니다.
            int personSize = personQ.size();
            for (int i = 0; i < personSize; i++) {
                Node person = personQ.poll();

                if (person.x == 0 || person.x == n - 1 || person.y == 0 || person.y == m - 1) {
                    System.out.print(person.time);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = person.x + dx[d];
                    int ny = person.y + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == '.') {
                        maze[nx][ny] = 'J';
                        personQ.add(new Node(nx, ny, person.time + 1));
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}