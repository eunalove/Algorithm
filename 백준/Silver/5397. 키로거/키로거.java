import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Character> leftStack;
		Stack<Character> rightStack;
		for (int t = 0; t < n; t++) {

			leftStack = new Stack<Character>();
			rightStack = new Stack<Character>();

			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {

				Character current = str.charAt(i);

				switch (current) {
				case '<':
					if (leftStack.isEmpty())
						continue;
					rightStack.push(leftStack.pop());
					break;

				case '>':
					if (rightStack.isEmpty())
						continue;
					leftStack.push(rightStack.pop());
					break;

				case '-':
					if (leftStack.isEmpty())
						continue;
					leftStack.pop();
					break;

				default:
					leftStack.push(current);
				}
			}
			
			while (!rightStack.isEmpty()) {
				leftStack.push(rightStack.pop());
			}

			for (Character c : leftStack) {
				sb.append(c);
			}

			sb.append("\n");

		}

		System.out.print(sb);

	}

}