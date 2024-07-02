package a0702.kruskal;

import java.util.Arrays;

public class Union_Find {
	static int[] root;
	static int N;
	static void make() {
		root = new int[N+1];
		for(int i = 1; i <= N; i++) root[i] = i;
	}
	
	static int find(int x) {
		if(root[x] == x) return x;
		else return find(root[x]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		root[rootB] = rootA;
	}
	public static void main(String[] args) {
		N = 6;
		make();
		
		union(1,4);
		union(2,3);
		union(1,2);
		union(5,6);
		System.out.println("{0, 1, 2, 3, 4, 5, 6}");
		System.out.println(Arrays.toString(root));
		
	}

}
