package bj;

import java.io.*;
import java.util.*;

public class bj2798 {

	static int n, m;
	static int[] a;
	static boolean[] v;
	static int ans = 0;
	static void back(int depth, int num) {
		if(num > m) return;
		if(depth == 3) {
			ans = Math.max(ans, num);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(v[i]) continue;
			v[i] = true;
			back(depth+1, num + a[i]);
			v[i] = false;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		v = new boolean[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0, 0);
		
		
		System.out.println(ans);
	}

}
