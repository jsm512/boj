package bj;

import java.io.*;
import java.util.*;
public class bj1922 {
	static int N;
	static int[][] g;
	static int[] p;
	
	static void make() {
		p = new int[N+1];
		for(int i = 1; i <= N; i++) p[i] = i;
	}
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		int v = find(a);
		int u = find(b);
		if(v == u) return false;
		p[u] = v;
		return true;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		g = new int[M][3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[i] = new int[] {from, to, cost};
		}
		
		Arrays.sort(g,(o1,o2) -> Integer.compare(o1[2], o2[2]));
		make();
		int sum = 0, cnt = 0;
		for(int[] e : g) {
			if(union(e[0],e[1])) {
				sum += e[2];
				if(++cnt == N-1) break;
			}
		}
		System.out.println(sum);
	}

}
