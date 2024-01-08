/*
자바의 TreeMap을 이용해서 이진탐색트리를 사용하였다.
이진탐색트리는 데이터가 사전순으로 정렬된 값을 저장한다
이진탐색트리의 탐색,추가,삭제는 O(logN)의 시간이 걸린다.
firstKey(), lastKey(), firstEntry(), lastEntry()정도는 기억하자
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		StringBuilder sb= new StringBuilder();
		
		int t= Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			int n= Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tm= new TreeMap<Integer, Integer>();
			
			while(n-->0) {
				
			st= new StringTokenizer(br.readLine());
			char di= st.nextToken().charAt(0);
			int cnt= Integer.parseInt(st.nextToken());
			
			switch(di) {
			case 'I':
				tm.put(cnt, tm.getOrDefault(cnt, 0)+1);
				break;
				
			case 'D':
				if(!tm.isEmpty()) {
				if(cnt==1) {
					//최댓값 삭제
					int key= tm.lastKey();
					int ex= tm.get(key);
					ex--;
					
					if(ex == 0) {
						tm.remove(key);
					}else {
						tm.put(key, ex);
					}
					
				}else {
					//최솟값 삭제
					int key= tm.firstKey();
					int ex= tm.get(key);
					ex--;
					
					if(ex == 0) {
						tm.remove(key);
					}else {
						tm.put(key, ex);
					}
				}
			}
			
			}
			}
			
			if(tm.isEmpty()) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			}
			
		}
		
		
		System.out.print(sb);
		
		
		
	}

}