package bj;

import java.io.*;
import java.util.*;

public class bj2667 {
	static final int[] di = {-1,0,1,0};
	static final int[] dj = {0,1,0,-1};
	static int n;
	static int[][] a;
	static boolean[][] v;
	static int ans = 0;
	static int cnt = 1;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	static void dfs(int x, int y) {
		v[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int ni = x + di[i];
			int nj = y + dj[i];
			
			if(ni >= 0 && nj >= 0 && ni < n && nj < n 
					&& !v[ni][nj] && a[ni][nj] == 1) {
				dfs(ni,nj);
				cnt++;
			}
		}
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			x = ij[0];
			y = ij[1];
			for(int i = 0; i < 4; i++) {
				int ni = x + di[i];
				int nj = y + dj[i];
				
				if(ni >= 0 && nj >= 0 && ni < n && nj < n
						&& !v[ni][nj] && a[ni][nj] == 1) {
					q.offer(new int[] {ni,nj});
					v[ni][nj] = true;
					cnt++;
				}
			}
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n][n];
		v = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1 && !v[i][j]) {
//					dfs(i,j);
					bfs(i,j);
					ans++;
					arr.add(cnt);
				}
				cnt = 1;
			}
		}
		
		System.out.println(ans);
		Collections.sort(arr);
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
