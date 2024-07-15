package bj;

import java.io.*;
import java.util.*;

public class bj17086 {
	static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int n, m;
	static int[][] a;
	static boolean[][] v;
	static int ans = 0;

	static int bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[n][m];
		q.offer(new int[] { x, y, 0});
		v[x][y] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
				int[] now = q.poll();
				x = now[0];
				y = now[1];
				cnt = now[2];
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
						if (a[nx][ny] == 0 && !v[nx][ny]) {
							q.offer(new int[] { nx, ny, cnt+1});
							v[nx][ny] = true;
						}
						if (a[nx][ny] == 1)
							return cnt + 1;
					}
				}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);

	}

}
