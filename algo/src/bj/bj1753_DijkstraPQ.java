package bj;

import java.io.*;
import java.util.*;

public class bj1753_DijkstraPQ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(("res/input_bj_1753.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken())+1;
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<int[]>[] g = new List[N];
		for (int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] { to, cost });
		}
		
//		for(int[] x : g[0]) {
//			System.out.println(x[0] + " " + x[1]);
//		}
		boolean[] v = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		v[K] = true;
		for(int[] x : g[K]) {
			dist[x[0]] = Math.min(dist[x[0]], x[1]);
		}
		
		for(int i = 2; i < N; i++) {
			int min = 0;
			for(int j = 1; j < N; j++) {
				if(!v[j] && dist[min] > dist[j]) {
					min = j;
				}
			}
			if(min == 0) break;
			v[min] = true;
			
			for(int[] x : g[min]) {
				dist[x[0]] = Math.min(dist[x[0]], dist[min] + x[1]);
			}
		}
		for(int i = 1; i < N; i++) {
			sb.append(v[i] ? dist[i] : "INF").append("\n");
		}
		System.out.println(sb);
	}
}
