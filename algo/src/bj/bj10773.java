package bj;

import java.io.*;
import java.util.*;

public class bj10773 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> s = new ArrayDeque<>();
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(!s.isEmpty() && n == 0) {
				s.pop();
				continue;
			}
			s.push(n);
		}
		
		int ans = 0;
		
		for(int i : s) {
			ans += i;
		}
		System.out.println(ans);
		
	}

}
