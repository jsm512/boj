package bj;

import java.io.*;
import java.util.*;

public class bj2206 {
	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] a;
	
	static int bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		//벽을 제거한적이 있는지 체크하기 위해 삼차원배열 사용
		int[][][] v = new int[n][m][2];
		
		q.offer(new int[] {x,y,0});
		v[x][y][0] = 1;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			x = t[0];
			y = t[1];
			int z = t[2];
			
			if(x == n-1 && y == m-1) return v[x][y][z];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					//다음 노드가 길인 경우
					if(a[nx][ny] == 0) {
						if(v[nx][ny][z] == 0) {
							q.offer(new int[] {nx,ny,z});
							v[nx][ny][z] = v[x][y][z] + 1;
						}
					}
					//벽인 경우
					else {
						if(z==0) {
							if(v[nx][ny][1] == 0) {
								q.offer(new int[] {nx,ny,1});
								v[nx][ny][1] = v[x][y][0] + 1;
							}
						}
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}

}
