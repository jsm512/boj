package bj;

import java.io.*;
import java.util.*;

public class bj14889 {
	static int n;
	static int[][] a;
	static boolean[] check;

	static int ans = Integer.MAX_VALUE;

	static void d(int depth, int start) {
		if (depth == n / 2) {
			solution();
			return;
		}
		for (int i = start; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				d(depth + 1, i + 1);
				check[i] = false;
			}
		}
	}

	static void solution() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (check[i] && check[j]) {
					start += a[i][j];
					start += a[j][i];
				} else if (!check[i] && !check[j]) {
					link += a[i][j];
					link += a[j][i];
				}
			}
		}
		int cnt = Math.abs(start - link);
		if(cnt < ans) {
			ans = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		check = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d(0, 0);

		System.out.println(ans);
	}

}
