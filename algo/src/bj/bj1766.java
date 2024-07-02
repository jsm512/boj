package bj;

import java.io.*;
import java.util.*;

public class bj1766 {
	static int N, M;
	static List<Integer>[] a;
	static int[] deg;
	
	static void bfs() {
//		ArrayDeque<Integer> q = new ArrayDeque<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		//최소힙으로 풀면 문제 번호가 작은 순서대로 뽑아줌
		for(int i = 1; i <= N; i++) {
			if(deg[i] == 0) {
				q.offer(i);
				//억지로 막구현 해봄
//				for(int j : a[i]) {
//					deg[j]--;
//					if(deg[j] == 0) q.offer(j);
//				}
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.poll();
			System.out.print(i + " ");
			for(int j : a[i]) {
				deg[j]--;
				if(deg[j] == 0) q.offer(j);
			}
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new List[N+1]; for(int i = 1; i <= N; i++) a[i] = new ArrayList<>();
		deg = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			a[v].add(u);
			deg[u]++;
		}
		
		bfs();
	}

}
