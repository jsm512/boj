package bj;

import java.io.*;
import java.util.*;

public class bj2178 {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static int N, M;
	static int[][] a;
	
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		a[x][y] = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && a[nx][ny] == 1) {
					q.offer(new int[] {nx,ny});
					a[nx][ny] = a[x][y] + 1;
				}
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N][M];
		
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(a[N-1][M-1]);
	}

}
