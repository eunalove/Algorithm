import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		Deque<Integer> deque = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {

			case "push_front":
				int a = Integer.parseInt(st.nextToken());
				deque.addFirst(a);
				break;

			case "push_back":
				int b = Integer.parseInt(st.nextToken());
				deque.addLast(b);
				break;
				
			case "pop_front":
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
				break;

			case "pop_back":
				sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
				break;

			case "size":
				sb.append(deque.size()).append("\n");
				break;

			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;

			case "front":
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
				break;

			case "back":
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
				break;

			}
		}

		System.out.print(sb);
	}
}