package bj;

import java.io.*;
import java.util.*;

public class bj16234 {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static int n, l, r;
	static int[][] a;
	static boolean[][] v;
	static ArrayList<Node> list;
	
	static int move() {
		int ans = 0;
		while(true) {
			boolean isMove = false;
			v = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!v[i][j]) {
						int sum = bfs(i,j);
						if(list.size() > 1) {
							MovePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) return ans;
			ans++;
		}
	}
	
	static int bfs(int x, int y) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x,y));
		list.add(new Node(x,y));
		v[x][y] = true;
		
		int sum = a[x][y];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !v[nx][ny]) {
					int diff = Math.abs(a[cur.x][cur.y] - a[nx][ny]);
					if(l <= diff && diff <= r) {
						q.offer(new Node(nx,ny));
						list.add(new Node(nx,ny));
						sum += a[nx][ny];
						v[nx][ny] = true;
					}
				}
			}
		}
		return sum;
	}
	
	static void MovePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			a[n.x][n.y] = avg;
		}
	}
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
	}
}
