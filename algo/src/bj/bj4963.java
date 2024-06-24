package bj;

import java.io.*;
import java.util.*;

public class bj4963 {
	/* 8방 탐색
	 * (-1,-1)(-1,0)(-1,1)
	 * (0,-1)   x   (0, 1)
	 * (1, -1)(1, 0)(1, 1)
	 */
	static final int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int n, m;
	static int[][] a;
	static boolean[][] v;

	static void dfs(int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 8; i++) {

			int ni = x + di[i];
			int nj = y + dj[i];

			if (ni >= 0 && nj >= 0 && ni < m && nj < n && !v[ni][nj] && a[ni][nj] == 1) {

				dfs(ni, nj);
			}
		}
	}

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];

			for (int d = 0; d < 8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni >= 0 && nj >= 0 && ni < m && nj < n && !v[ni][nj] && a[ni][nj] == 1) {
					q.offer(new int[] { ni, nj });
					v[ni][nj] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0) {
				break;
			}

			a = new int[m][n];
			v = new boolean[m][n];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == 1 && !v[i][j]) {
//						dfs(i, j);
						bfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		br.close();
	}

}
