package a0705.knapsack;

import java.io.*;
import java.util.*;

public class CoinDpMain2 {

	public static void main(String[] args) throws Exception{
		int N = 8;
		int[] dp = new int[N+1];
		
//		for(int i = 1; i <= N; i++) {
//			int min = Integer.MAX_VALUE;
//			if(i - 1 >= 0 && min > dp[i-1] + 1) min = dp[i-1]+1;
//			if(i - 4 >= 0 && min > dp[i-4] + 1) min = dp[i-4]+1;
//			if(i - 6 >= 0 && min > dp[i-6] + 1) min = dp[i-6]+1;
//			dp[i] = min;
//		}
		int[] coin = {6,4,1};
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
	
		for(int c : coin) {
			for(int i = c; i <= N; i++) {
				if(dp[i - c] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i-c] + 1);
				}
			}
		}
		System.out.println(dp[N]);
		
	}

}
