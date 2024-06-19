package bj;

import java.io.*;
import java.util.*;

public class bj14891 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int[][] a = new int[4][8];
			
			for(int i = 0; i < 4; i++) {
				String str = br.readLine();
				for(int j = 0; j < 8; j++) {
					a[i][j] = str.charAt(j) - '0';
				}
			}
			
			int k = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
			}
			
			
			
			sb.append("#").append(tc).append(" ").append("ans").append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
