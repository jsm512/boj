package a0701.graph;

import java.io.*;
import java.util.*;

public class GraphNodeMain {
	static int N;
	static Node[] g; //인접행렬(matrix)
	static boolean[] v;
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print((char)(i+'A') + " ");
			for(Node j = g[i]; j != null; j=j.link) {
				if(!v[j.vertex]) {
					v[j.vertex] = true;
					q.offer(j.vertex);
				}
			}
		}
	}
	static void dfs(int i) {
		v[i] = true;
		System.out.print((char)(i+'A') + " ");
		for(Node j = g[i]; j!=null; j=j.link) {
			if(!v[j.vertex]) {
				dfs(j.vertex);
			}
		}
	}
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0701/graph/input_graph.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		g = new Node[N];
		v = new boolean[N];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from] = new Node(to,g[from]);
			g[to] = new Node(from,g[to]);
		}
//		for(Node a : g) System.out.println(a); System.out.println();
//		for(int[] a: g) System.out.println(Arrays.toString(a));
//		System.out.println();
		
		for(int i = 0; i < N; i++) System.out.println(""+(char)(i+'A')+i+": "+g[i]);
//		System.out.println();
		bfs(0);
//		dfs(0);
		
		br.close();
	}
	static class Node{
		int vertex;
		Node link;
		Node(int vertex, Node link){
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return ""+(char)(vertex + 'A') + vertex + "->" + link;
		}
	}

}

/*
===========DFS=============
A B D F E C G
A C E F G D B
==========BFS=============
A B C D E F G 
A C B E D F G 
 */

/*
A0 -> 1 -> 2 -> null
B1 -> 0 -> 3 -> 4 -> null
C2 -> 0 -> 4 -> null
D3 -> 1 -> 5 -> null
E4 -> 1 -> 2 -> 5 -> null
F5 -> 3 -> 4 -> 6 -> null
G6 -> 5 -> null
 */
