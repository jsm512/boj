package a0702.kruskal;

import java.io.*;
import java.util.*;

public class KruskalMain {
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
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; //사이클 형성하는지 체크
		p[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args)throws Exception {
//		System.setIn(new FileInputStream("src/a0702/kruskal/input_kruskal.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new int[E][3];
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			g[i] = new int[] {from, to, cost};
			
		}
//		for(int[] a : g) System.out.println(Arrays.toString(a));
		Arrays.sort(g,(o1,o2) -> Integer.compare(o1[2], o2[2]));
//		for(int[] a : g) System.out.println(Arrays.toString(a));
		make();
		int sum = 0, cnt = 0;
		for(int[] e : g) {
			if(union(e[0],e[1])) {
				sum += e[2];
				if(++cnt == N-1) break;
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
