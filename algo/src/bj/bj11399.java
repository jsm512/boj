package bj;

import java.io.*;
import java.util.*;
	
public class bj11399 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p);
		
		int ans = 0;
		int pi = 0;
		for(int x : p) {
			pi += x;
			ans += pi;
		}
		System.out.println(ans);
	}

}
