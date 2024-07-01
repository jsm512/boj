package bj;

import java.io.*;
import java.util.*;

public class bj2606 {
	static class Node {
		int vertex;
		Node link;

		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int n, m;
	static Node[] a;
	static boolean[] v;
	static int ans = 0;

//	static void dfs(int start) {
//		v[start] = true;
//		ans++;
//		for (Node i = a[start]; i != null; i = i.link) {
//			if (!v[i.vertex]) {
//				dfs(i.vertex);
//			}
//		}
//	}
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		v[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			ans++;
			for(Node i = a[start]; i != null; i=i.link) {
				if(!v[i.vertex]) {
					q.offer(i.vertex);
					v[i.vertex] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		a = new Node[n + 1];
		v = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x] = new Node(y, a[x]);
			a[y] = new Node(x, a[y]);
		}

//		dfs(1);
		bfs(1);
		System.out.println(ans-1);
	}

}
