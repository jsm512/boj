package bj;

import java.io.*;
import java.util.*;

public class bj14889_ver2 {
	static int n;
	static int[][] a;

	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		

		System.out.println(ans);
	}

}
