package bj;

import java.io.*;
import java.util.*;

public class bj4485_PQ {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static int n;
	static int[][] a;
	static int[][] dist;
	public static void main(String[] args)throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_4485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while(true) {
			t++;
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			a = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dist[i][j] = 10000000;
				}
			}
			
			PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[2], o2[2]));
			
			dist[0][0] = 0;
			q.offer(new int[] {0,0,0});
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				int w = now[2];
				
				if(dist[x][y] < w) continue;
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
						if(dist[nx][ny] > w + a[x][y]) {
							dist[nx][ny] = w + a[x][y];
							q.offer(new int[] {nx,ny,dist[nx][ny]});
						}
					}
				}
				
			}
			sb.append("Problem ").append(t).append(": ")
			.append(dist[n-1][n-1] + a[n-1][n-1]).append("\n");
		}
		System.out.println(sb);
	}
}
