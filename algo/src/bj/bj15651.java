package bj;

import java.io.*;
import java.util.*;

public class bj15651 {
	static int n, m;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();

	static void perm(int cnt) {
		if (cnt == m) {
			for (int x : b)
				sb.append(x).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			b[cnt] = a[i];
			perm(cnt + 1);
		}
	}

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		b = new int[m];

		perm(0);
		System.out.println(sb.toString());
	}
}
