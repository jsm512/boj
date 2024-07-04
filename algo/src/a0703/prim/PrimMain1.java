package a0703.prim;

import java.io.*;
import java.util.*;

public class PrimMain1 {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0703/prim/input_prim.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<int[]>[] g = new List[N];
		for(int i = 0; i < N; i++) g[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[] {j,c});
			}
		}
		
		boolean[] v = new boolean[N];
		int[] w = new int[N];
//		Arrays.fill(minEdge, Integer.MAX_VALUE);
		for(int i = 0; i < N; i++) w[i] = Integer.MAX_VALUE;
		
		int sum = 0, cnt = 0;
		w[0] = 0;
		
		for(int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j = 0; j < N; j++) {
				if(!v[j] && min > w[j]) {
					min = w[j];
					minVertex = j;
				}
			}
			v[minVertex] = true;
			sum += min;
			if(cnt++ == N-1) break; //모든 정점을 연결하면 종료 
			
			for(int[] j : g[minVertex]) {
				if(!v[j[0]] && w[j[0]] > j[1]) {
					w[j[0]] = j[1];
				}
			}
		}
		System.out.println(sum);
	}
}
