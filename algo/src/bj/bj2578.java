package bj;

import java.io.*;
import java.util.*;

public class bj2578 {
	static int[][] a = new int[5][5];
	static int check_cnt = 0;

	static void call(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (a[i][j] == num) {
					a[i][j] = 0;
					row();
					col();
					rowcol();
					colrow();
				}
			}
		}
	}
	static void row() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(a[i][j] == 0) cnt++;
			}
			if(cnt == 5) check_cnt++;
		}
	}
	static void col() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(a[j][i] == 0) cnt++;
			}
			if(cnt == 5) check_cnt++;
		}
	}
	static void rowcol() {
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(a[i][i] == 0) cnt++;
		}
		if(cnt == 5) check_cnt++;
	}
	static void colrow() {
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(a[i][4-i] == 0) cnt++;
		}
		if(cnt == 5) check_cnt++;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				call(n);

				if (check_cnt >= 3) {
					System.out.println(ans+1);
					System.exit(0);
				}
				check_cnt = 0;
				ans++;
			}
		}

	}
}
