package bj;

import java.io.*;
import java.util.*;

public class bj1074 {
	static int r, c;
	static int ans = 0;

	static void split(int x, int y, int n) {
		if (x == r && y == c) {
			System.out.println(ans);
			return;
		}
		if (r < x + n && r >= x && c < y + n && c >= y) {
			int s = n / 2;
			split(x, y, s);
			split(x, y + s, s);
			split(x + s, y, s);
			split(x + s, y + s, s);
		}else {
			ans += n*n;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, n);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		split(0, 0, size);
	}

}
