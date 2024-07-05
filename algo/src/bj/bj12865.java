package bj;

import java.io.*;
import java.util.*;

public class bj12865 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N];
		int[] V = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[K+1];
		
		for(int i = 0; i < N; i++) {
			for(int j = K; j > 0; j--) {
				if(W[i] <= j) {
					dp[j] = Math.max(dp[j], V[i] + dp[j-W[i]]);
				}
			}
		}
		System.out.println(dp[K]);
	}

}
