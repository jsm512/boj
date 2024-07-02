package bj;
import java.io.*;
import java.util.*;

public class bj24391 {
	static int N;
	static int[] p;
	static int find(int a) { //부모 노드를 찾음
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return; //이미 연결됨
		//작은 값이 부모 -> 자식 노드에 작은 값을 넣는다.
		if(aRoot > bRoot) p[aRoot] = bRoot;
		else {
			p[bRoot] = aRoot;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		
		int[] t = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 1; i < N; i++) {
			if(find(t[i]) != find(t[i+1])) ans++;
		}
		System.out.println(ans);
		
	}

}
