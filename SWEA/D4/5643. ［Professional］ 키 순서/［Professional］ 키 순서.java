import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int n, m, ans;
	static ArrayList<Integer>[] tallList;
	static ArrayList<Integer>[] shortList;
	static boolean visited[];
	static boolean visited2[];
	static boolean result[];
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws  IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T= Integer.parseInt(br.readLine().trim());

		for(int tc= 1; tc<T+1; tc++) {

			ans= 0;
			
			n= Integer.parseInt(br.readLine().trim());
			m= Integer.parseInt(br.readLine().trim());

			tallList= new ArrayList[n+1];
			shortList= new ArrayList[n+1];

			for(int i=1; i<n+1; i++) {
				tallList[i]= new ArrayList<Integer>();
				shortList[i]= new ArrayList<Integer>();
			}

			int a,b;

			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine().trim());
				a= Integer.parseInt(st.nextToken());
				b= Integer.parseInt(st.nextToken());

				shortList[a].add(b);
				tallList[b].add(a);

			}

			for(int i=1; i<n+1; i++) {
				
				visited= new boolean[n+1];
				simul(i);
				visited2= new boolean[n+1];
				simul2(i);
				result= new boolean[n+1];
				
				for(int j=1; j<visited.length; j++) {
					if(visited[j]) {
						result[j]= true;
					}
				}
				
				for(int j=1; j<visited2.length; j++) {
					if(visited2[j]) {
						result[j]= true;
					}
				}
				
				result[i]= true;
				
				boolean flag= false;
				
				for(int j=1; j<result.length; j++) {
					if(!result[j]) {
						flag= true;
					}
				}
				
				if(!flag) ans+=1;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		
		System.out.print(sb);
	}

	static void simul(int i) {

		for(int x: shortList[i]) {

			if(!visited[x]) {

				visited[x]= true;
				simul(x);

			}
		}

	}

	static void simul2(int i) {

		for(int x: tallList[i]) {

			if(!visited2[x]) {

				visited2[x]= true;
				simul2(x);

			}
		}

	}




}