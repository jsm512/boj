package a0624.stackqueue;

import java.util.*;

public class BfsDfsDepth {
	// 상우하좌
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	static int n = 5, c = 0;
	static int[][] a;
	static boolean[][] v;

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] { i, j});
		int depth = 0;
		while (!q.isEmpty()) {
			int S = q.size();
			for (int s = 0; s < S; s++) {
				int[] ij = q.poll();
				i = ij[0];
				j = ij[1];
				a[i][j] = c++;
				System.out.println(depth);
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni >= 0 && nj >= 0 && ni < n && nj < n && !v[ni][nj]) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj});
					}
				}
			}
			depth++;
		}
	}

	static void dfs(int i, int j, int depth) {
		v[i][j] = true;
		a[i][j] = c++;
		System.err.println(depth);
		for (int[] b : a)
			System.out.println(Arrays.toString(b));
		System.out.println();
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni >= 0 && nj >= 0 && ni < n && nj < n && !v[ni][nj]) {
				dfs(ni, nj, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		a = new int[n][n];
		v = new boolean[n][n];
		c = 1;

		bfs(n / 2, n / 2);
//		dfs(n/2,n/2,0);

		for (int[] b : a)
			System.out.println(Arrays.toString(b));
		System.out.println();

	}

}
