package bj;

import java.io.*;
import java.util.*;

public class bj1260_Node {
	static class Node{
		int vertex;
		Node link;
		
		Node(int vertex, Node link){
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	static int n,m,v;
	static Node[] a;
	static boolean[] visit;
	
	static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + " ");
		for(Node i = a[start]; i != null; i=i.link) {
			if(!visit[i.vertex]) {
				dfs(i.vertex);
			}
		}
	}
	
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visit[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.print(start + " ");
			for(Node i = a[start]; i != null; i = i.link) {
				if(!visit[i.vertex]) {
					q.offer(i.vertex);
					visit[i.vertex] = true;
				}
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		a = new Node[n+1];
		visit = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x] = insertSort(a[x], y);
			a[y] = insertSort(a[y], x);
		}
//		 for (int i = 1; i <= n; i++) {
//	            System.out.print("정점 " + i + "의 인접 리스트: ");
//	            for (Node j = a[i]; j != null; j = j.link) {
//	                System.out.print(j.vertex + " ");
//	            }
//	            System.out.println();
//	        }
		dfs(v);
		System.out.println();
		visit = new boolean[n+1];
		bfs(v);
		
	}
	static Node insertSort(Node head, int vertex) {
		Node newNode = new Node(vertex, null);
		if(head == null || head.vertex > vertex) {
			newNode.link = head;
			return newNode;
		}
		
		Node cur = head;
		while(cur.link != null && cur.link.vertex < vertex){
			cur = cur.link;
		}
		newNode.link = cur.link;
		cur.link = newNode;
		return head;
	}

}
