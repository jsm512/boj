package a0702.kruskal;

import java.io.*;
import java.util.*;
/*
 * 정점 번호가 빠른 것을 부모로
 */
public class DisjointSetMain {
	static int N;
	static int[] p;
	
	static void make() {
		p = new int[N];
		for(int i = 0; i < N; i++) p[i] = i;
	}
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args)throws Exception {
		N = 5;
		make();
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		
		
		System.out.println(union(0,1));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		System.out.println(union(2,1));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		System.out.println(union(3,2));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		System.out.println(union(4,3));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		
		System.out.println("=========find========");
		System.out.println(find(4));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		System.out.println(find(3));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		System.out.println(find(2));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
		System.out.println(find(0));
		System.out.println("{0, 1, 2, 3, 4}");
		System.out.println(Arrays.toString(p));
//		System.out.println(find(1));
//		System.out.println("{0, 1, 2, 3, 4}");
//		System.out.println(Arrays.toString(p));
	}

}
