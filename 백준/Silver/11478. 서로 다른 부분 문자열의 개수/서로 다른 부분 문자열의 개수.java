;/*
 * 처음 보자마자 dfs가 떠올랐고 조합으로 풀어야하나 싶었지만
 * 숫자가 최대 1000이라는걸 보고 아니란걸 알았다
 * HashSet을 쓰면 add가 O(1)의 시간복잡도를 가지므로 시간 내에 쓸 수 있다.
 * 그리고 substring에서 endIndex는 꼭 인덱스+1 해야함
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		
		Set<String> set= new HashSet();
        int n= str.length();
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j< n+1; j++) {
				set.add(str.substring(i,j));
			}
		}
		
		System.out.println(set.size());
		
		
	}
	

}