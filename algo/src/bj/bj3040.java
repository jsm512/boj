package bj;

import java.io.*;
import java.util.*;

public class bj3040 {
	static int[] a;
	static int[] b;
	static boolean[] v;

	static StringBuilder sb;

	static void back(int depth, int sum) {
		if (depth == 7) {
			if (sum == 100) {
				sb = new StringBuilder();
				for (int i : b) {
					sb.append(i).append("\n");
				}
				return;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				b[depth] = a[i];
				back(depth + 1, sum + a[i]);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = new int[9];
		b = new int[7];
		v = new boolean[9];

		for (int i = 0; i < 9; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		back(0, 0);

		System.out.println(sb);
	}

}
