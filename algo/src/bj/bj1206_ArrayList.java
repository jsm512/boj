package bj;

import java.io.*;
import java.util.*;

public class bj1206_ArrayList {
	static int n,m,v;
	static List<Integer>[] a;
	static boolean[] visit;
	
	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + " ");
		for(int i : a[start]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.print(start + " ");
			for(int i : a[start]) {
				if(!visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		a = new List[n+1];
		for(int i = 0; i <= n; i++) a[i] = new ArrayList<>();
		visit = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y);
			a[y].add(x);
		}
		//문제에서 정점 번호가 작은 것 먼저 방문이라 했으니 오름차순 정렬이 필요
		for(List<Integer> b : a) {
			Collections.sort(b);
		}
		
		dfs(v);
		System.out.println();
		visit = new boolean[n+1];
		bfs(v);
	}

}
