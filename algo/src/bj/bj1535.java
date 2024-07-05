package bj;

import java.io.*;
import java.util.*;
public class bj1535 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] L = new int[n];
		int[] J = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		int hp = 100;
		int[] dp = new int[hp+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = hp; j > 0; j--) {
				if(L[i] <= j) {
					dp[j] = Math.max(dp[j], J[i]+dp[j-L[i]]);
//					System.out.println(i+" :"+Arrays.toString(dp));System.out.println();
				}
			}
		}
		System.out.println(dp[hp-1]);
		
	}

}
