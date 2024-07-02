package bj;

import java.io.*;
import java.util.*;

public class bj16562 {
	static int[] p;
	static int[] coin;
	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y) return;
		if (coin[x] >= coin[y]) p[x] = y;
		else p[y] = x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		coin = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int ans = 0;
		boolean[] v = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			int root = find(i);
			// find(1) root = 1
			if(v[root]) {
				v[i] = true;
				continue;
			}
			ans += coin[root];
			v[root] = true;
			v[i] = true;
		}
		
		if(ans > k) System.out.println("Oh no");
		else {
			System.out.println(ans);
		}
	}

}
