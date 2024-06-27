package bj;

import java.io.*;
import java.util.*;

public class bj11047 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] c = new int[n];
		for(int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = c.length - 1;
		int ans = 0;
		while(k != 0) {
//			int cnt = k / c[idx];
//			if(cnt != 0) {
//				k = k % (c[idx] * cnt);
//			}
//			idx--;
//			ans += cnt;
			if(k >= c[idx]) {
				ans += (k / c[idx]);
				k = k % c[idx];
			}
			idx--;
		}
		System.out.println(ans);
	}

}
