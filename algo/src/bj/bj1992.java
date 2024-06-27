package bj;

import java.io.*;
import java.util.*;

public class bj1992 {
	static StringBuilder sb = new StringBuilder();
	static int[][] a;
	static void split(int r, int c, int size) {
		if(check(r,c,size)) {
			sb.append(a[r][c]);
			return;
		}
		int n = size / 2;
		split(r,c,n);
		split(r,c + n,n);
		split(r + n,c,n);
		split(r + n,c + n ,n);
		sb.append(")");
	}
	static boolean check(int r, int c, int size) {
		
		int s = a[r][c];
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(a[i][j] != s) {
					sb.append("(");
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}
		split(0,0,n);
		System.out.println(sb.toString());
		
	}

}
