package bj;

import java.io.*;
import java.util.*;

public class bj2164 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(true) {
			if(q.size() == 1) {
				ans = q.poll();
				break;
			}
			q.poll();
			int t = q.poll();
			q.offer(t);
		}
		
		System.out.println(ans);
	}

}
