package bj;

import java.io.*;
import java.util.*;

public class bj1189 {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static int R, C, K;
	static char[][] a;
	static boolean[][] v;
	static int ans = 0;
	static void dfs(int depth, int x ,int y) {
		if(x == 0 && y == C-1) {
			if(depth == K) {
				ans++;
			}
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C && !v[nx][ny] && a[nx][ny] != 'T') {
				v[nx][ny] = true;
//				System.out.println(nx + " " + ny);
				dfs(depth+1,nx,ny);
				v[nx][ny] = false;
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a = new char[R][C];
		v = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				a[i][j] = str.charAt(j);
			}
		}
		v[R-1][0] = true;
		dfs(1,R-1,0);
		System.out.println(ans);
	}

}
