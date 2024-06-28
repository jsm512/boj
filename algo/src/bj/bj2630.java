package bj;
import java.io.*;
import java.util.*;

public class bj2630 {
	static int n;
	static int[][] a;
	static int white_cnt = 0, blue_cnt = 0;
	
	//분할
	static void split(int r, int c, int size) {
		
		if(check(r,c,size)) {
			if(a[r][c] == 0) white_cnt++;
			else blue_cnt++;
			return;
		}
		int s = size / 2;
		split(r,c,s); //2사
		split(r,c+s,s); //1사
		split(r+s,c,s); //3사
		split(r+s,c+s,s); //4사
	}
	
	static boolean check(int r, int c, int size) {
		int check_color = a[r][c];
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
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
