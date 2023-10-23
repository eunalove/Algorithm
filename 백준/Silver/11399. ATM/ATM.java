/*
쉬운 시뮬레이션 문제
주어진 문제에서 가장 작은 답을 구하는 경우는
정렬했을 때임을 안다면 쉽게 풀림
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int sum_int= 0;
		
		int sum[]= new int[n];
		
		for(int i=0; i<list.size(); i++) {
			sum_int+=list.get(i); 
			sum[i] = sum_int;
		}
		
		int ans= 0;
		
		for(int x: sum) {
			ans+= x;
		}
		
		System.out.print(ans);
		
		
	}

}