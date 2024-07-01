package bj;

import java.io.*;
import java.util.*;

public class bj1697 {
	static int n, k;
	static int[] visit = new int[100001];
	
	static int bfs(int x) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		visit[x] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < 3; i++) {
				int next;
				if(i == 0) next = now + 1;
				else if(i == 1) next = now - 1;
				else next = now * 2;
				if(next == k) return visit[now];
				
				if(next >= 0 && next < visit.length && visit[next] == 0) {
					q.offer(next);
					visit[next] = visit[now] + 1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(n));
	}
	
}
