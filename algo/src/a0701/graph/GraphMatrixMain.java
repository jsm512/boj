package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphMatrixMain {
	static int N;
	static int[][] g; //인접행렬(matrix)
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A') + " ");
			for(int j = 0; j < N; j++) {
				if(g[i][j] != 0 && !v[j]) {
					q.offer(j);
					v[j] = true;
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A') + " ");
//		for(int j = N-1; j >= 0; j--) { //뒤부터 DFS
		for(int j = 0; j < N; j++) {
			if(g[i][j] != 0 && !v[j]) {
				dfs(j);
			}
		}
	}
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		g = new int[N][N];
		v = new boolean[N];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from][to] = 1;
			g[to][from] = 1;
		}
//		for(int[] a: g) System.out.println(Arrays.toString(a));
//		System.out.println();
		bfs(0);
//		dfs(0);
		
		br.close();
	}

}

/*
===========DFS=============
A B D F E C G
A C E F G D B
==========BFS=============
A B C D E F G 
 */
