package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphListMain {
	static int N;
	static List<Integer>[] g; //인접행렬(matrix)
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A') + " ");
			for(int j : g[i]) {
				if(!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A') + " ");
		for(int j : g[i]) {
			if(!v[j]) {
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
		
		g = new List[N]; for(int i = 0; i < N; i++) g[i] = new ArrayList<>();
		v = new boolean[N];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
//		for(int[] a: g) System.out.println(Arrays.toString(a));
//		System.out.println();
		
//		for(int i = 0; i < N; i++) System.out.println(""+(char)(i+'A')+i+" "+g[i]);
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
