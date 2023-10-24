/*
최대 문자열 길이는 10만,
최대 연산의 갯수는 50만인데 시간제한은 2초이다.
어레이리스트나 링크드리스트로는 택도 없다
커서를 기준으로 왼쪽 스택, 오른쪽 스택을 만들어서
모든 연산을 O(1)로 만들어야 한다.
아이디어가 필요한 문제였다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		Stack<Character> leftStack= new Stack<Character>();
		Stack<Character> rightStack= new Stack<Character>();
		
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}

		StringTokenizer st = null;

		int cursor = str.length();
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {

			case "L":
				if (!leftStack.isEmpty())
					rightStack.push(leftStack.pop());
				break;

			case "D":
				if (!rightStack.isEmpty())
					leftStack.push(rightStack.pop());
				break;

			case "B":
				if (!leftStack.isEmpty())
					leftStack.pop();
				break;

			case "P":
				Character line = st.nextToken().charAt(0);
				leftStack.push(line);
				break;

			}
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		StringBuilder sb= new StringBuilder();
		
		while(!rightStack.isEmpty()){
			sb.append(rightStack.pop());
		}
		
		System.out.print(sb);
		
		
		
		

	}
}