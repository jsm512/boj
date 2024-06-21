package bj;

import java.io.*;
import java.util.*;

public class bj15656 {
	static int n, m;
	static int[] a;
	static int[] b;
	
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int depth) {
		if(depth == m) {
			for(int x : b) sb.append(x).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			b[depth] = a[i];
			perm(depth+1);
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		b = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		perm(0);
		
		System.out.println(sb.toString());
	}

}
