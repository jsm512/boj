package a0702.kruskal;

import java.io.*;
import java.util.*;

public class TopologicalSortBfsMain {
	static int N, M;
	static List<Integer>[] g; 
	static int[] indegree;
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0702/kruskal/input_topologicalsort.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		g = new List[N+1]; for(int i = 1; i <= N; i++) g[i] = new ArrayList<>();
		indegree = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			indegree[b]++; //진입차수누적
		}
//		System.out.println(Arrays.toString(indegree));
//		for(List<Integer> x : g) System.out.println(x);System.out.println();
		bfs();
		br.close();
	}
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
//		PriorityQueue<Integer> q = new PriorityQueue<>(); //정점 오름차순
		
		for(int i = 1; i < N + 1; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int i  = q.poll(); //정점번호
			System.out.print(i + " ");
			for(int j : g[i]) {
				if(--indegree[j] == 0) {
					q.offer(j);
				}
			}
		}
	}
}

/*
===========DFS=============
A B D F E C G
A C E F G D B
==========BFS=============
A B C D E F G 
 */
