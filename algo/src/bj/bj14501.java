package bj;

import java.io.*;
import java.util.*;

public class bj14501 {
	static int n, ans =0;
	static int[][] a;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input_bj_14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		a = new int[n+1][2];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,0);
		System.out.println(ans);
	}
	private static void dfs(int depth, int profit) {
		if(depth > n) {
			ans = Math.max(ans, profit);
			return;
		}
		int day = a[depth][0];
		int pro = a[depth][1];
		if(depth+day-1 <= n) 
			dfs(depth+day, profit+pro);
		dfs(depth+1, profit);
	}
}
