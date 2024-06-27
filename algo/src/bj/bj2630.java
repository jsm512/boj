package bj;
import java.io.*;
import java.util.*;

public class bj2630 {
//	static final int[] dx = {-1,0,1,0};
//	static final int[] dy = {0,1,0,-1};
	
	static int n;
	static int[][] a;
	static boolean[][] v;
	static int white_cnt = 0, blue_cnt = 0;
	
	//분할
	static void split(int r, int c, int n) {
		
		if(check(r,c,n)) {
			if(a[r][c] == 0) white_cnt++;
			else blue_cnt++;
			return;
		}
		int s = n / 2;
		split(r,c,s);
		split(r,c+s,s);
		split(r+s,c,s);
		split(r+s,c+s,s);
	}
	
	static boolean check(int r, int c, int n) {
		int check_color = a[r][c];
		
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(a[i][j] != check_color) return false;
			}
		}
		return true;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		split(0,0,n);
		
		System.out.print(white_cnt + "\n" + blue_cnt);
	}

}
