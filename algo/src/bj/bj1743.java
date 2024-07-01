package bj;

import java.io.*;
import java.util.*;

public class bj1743 {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
//	static class Node{
//		int vertex;
//		Node link;
//		
//		Node(int vertex, Node link){
//			this.vertex = vertex;
//			this.link = link;
//		}
//	}
	
	static int n,m,k;
	static int[][] a;
	static boolean[][] v;
	
	static int bfs(int x, int y) {
		int cnt = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
//			System.out.println(x + " " + y);s
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx <=n && ny <= m 
						&& !v[nx][ny] && a[nx][ny] == 1) {
					q.offer(new int[] {nx,ny});
					v[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n+1][m+1];
		v = new boolean[n+1][m+1];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = 1;
		}
		
//		System.out.println(Arrays.deepToString(a));
		
		int ans = 0;
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < m+1; j++) {
				if(a[i][j] == 1 && !v[i][j]) {
					ans = Math.max(ans, bfs(i,j));
				}
			}
		}
		System.out.println(ans);
		
		
		
	}

}