package bj;

import java.io.*;
import java.util.*;

public class bj1260 {
	static int n, m, v;
	static int[][] a;
	static boolean[] visit;

	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= n; i++) {
			if (a[start][i] != 0 && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			for(int i = 1; i <= n; i++) {
				if(a[now][i] != 0 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		a = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		visit[0] = true;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
			a[y][x] = 1;

		}
		dfs(v);
		System.out.println();
		visit = new boolean[n+1];
		visit[0] = true;
		bfs(v);
	}

}

/*
 * [ [] [0,0,1,1,1] [0,1,0,0,1] [0,1,0,0,1] [0,1,1,1,0]
 */
