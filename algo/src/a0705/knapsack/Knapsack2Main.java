package a0705.knapsack;

import java.io.*;
import java.util.*;
	
public class Knapsack2Main {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0705/knapsack/input_knapsack.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] weights = new int[n+1];
		int[] profits = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] dp = new int[n+1][w+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= w; j++) {
				if(weights[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], profits[i] + dp[i-1][j-weights[i]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		
		System.out.println(dp[n][w]);
		sc.close();
	}
}

/*

4
10
5 10
4 40
6 30
3 50


 */
