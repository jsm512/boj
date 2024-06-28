package bj;

import java.io.*;
import java.util.*;

public class bj6603 {
	static int n;
	static int[] a;
	static int[] b = new int[6];
	static boolean[] v;
	static int ans = 0;

	static StringBuilder sb = new StringBuilder();

	static void perm(int depth, int idx) {
		if (depth == 6) {
			for (int i : b) sb.append(i + " ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				b[depth] = a[i];
				perm(depth + 1, i);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			a = new int[n];
			v = new boolean[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			perm(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

}
