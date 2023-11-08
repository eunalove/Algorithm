import java.util.*;
import java.io.*;

public class Main {
	static int size = 1;
	static int N, r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		size = (int) Math.pow(2, N);

		int count = 0;
		int x = 0;
		int y = 0;

		while(size > 0) {
			size /= 2;			
			if(r < x+size && c < y+size) {
				count += 0;
			}
			else if(r < x+size) {
				count += size * size;
				y += size;
			}
            else if (c < y+size) {
                count += size * size * 2;
                x += size;
            }
            else {
                count += size * size * 3;
                x += size;
                y += size;
            }
	

			 // size가 1이 되면 종료.
			 if(size == 1) {
	                System.out.println(count);
	                break;
	         }
		}

	}

}