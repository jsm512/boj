package bj;

import java.io.*;
import java.util.*;

public class bj2961 {
	static int n;
	static int[][] a;
	static int ans = Integer.MAX_VALUE;

	static void subs(int depth, int s, int b) {
		if (depth == n) {
			if (s != 1) { //재료를 한번도 사용하지 않은 경우를 제외하고 최소값을 찾음
				ans = Math.min(ans, Math.abs(s - b));
				return;
			}
			return;
		}
		subs(depth + 1, s * a[depth][0], b + a[depth][1]);
		subs(depth + 1, s, b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		a = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subs(0, 1, 0);

		System.out.println(ans);
		
		br.close();
		
	}

}
