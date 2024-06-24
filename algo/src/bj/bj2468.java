package bj;

import java.io.*;
import java.util.*;

public class bj2468 {
	static final int[] di = {-1,0,1,0};
	static final int[] dj = {0,1,0,-1};
	static int n;
	static int[][] a;
	static boolean[][] v;
	static int ans = 1;
	
	static void dfs(int x, int y, int height) {
		v[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int ni = x + di[i];
			int nj = y + dj[i];
			
			if(ni >= 0 && nj >= 0 && ni < n && nj < n
					&& !v[ni][nj] && a[ni][nj] > height) {
				dfs(ni,nj,height);
			}
		}
	}
	
	static void bfs(int x, int y, int height) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			x = ij[0];
			y = ij[1];
			for(int i = 0; i < 4; i++) {
				int ni = x + di[i];
				int nj = y + dj[i];
				
				if(ni >= 0 && nj >= 0 && ni < n && nj < n
						&& !v[ni][nj] && a[ni][nj] > height) {
					q.offer(new int[] {ni,nj});
					v[ni][nj] = true;
				}
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		
		a = new int[n][n];
		
		int max_rain = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] > max_rain) max_rain = a[i][j];
			}
		}
		
		for(int tc = 1; tc <= max_rain; tc++) {
			v = new boolean[n][n];
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!v[i][j] && a[i][j] > tc) {
						dfs(i,j,tc);
//						bfs(i,j,tc);
						cnt++;
					}
				}
			}
			ans = Math.max(cnt, ans);
		}
		System.out.println(ans);
	}

}
