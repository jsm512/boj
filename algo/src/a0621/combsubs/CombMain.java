package a0621.combsubs;

import java.io.*;
import java.util.*;

public class CombMain {

	static int N = 5, R = 3, C = 0;
	static int[] a = { 1, 2, 3, 4, 5 }, b = new int[R];
//	static boolean[] v = new boolean[N];

	static void comb(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		// 재귀본문
		for (int i = start; i < N; i++) {
//			if (v[i]) continue;
//			v[i] = true;
			b[cnt] = a[i];
			comb(cnt + 1, i+1);
//			v[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		C = 0;
		comb(0, 0);
		System.out.println(C);
	}
}
