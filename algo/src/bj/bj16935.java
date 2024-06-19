package bj;

import java.io.*;
import java.util.*;

public class bj16935 {
	static int n, m, r, dir;
	static int[][] a;
	static int[][] t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		a = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			dir = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void six() {
		t = new int[n][m];
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m/2; j++) {
				t[n/2+i][j] = a[i][j];
			}
		}
		
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				t[i][m/2+j] = a[i][j];
			}
		}
		
		for(int i = n/2; i < n; i++) {
			for(int j = m/2; j < m; j++) {
				t[i-n/2][j] = a[i][j];
			}
		}
		
		for(int i = 0; i < n/2; i++) {
			for(int j = m/2; j < m; j++) {
				t[i][j-m/2] = a[i][j];
			}
		}
		
		a = t;

	}

	private static void five() {
		t = new int[n][m];
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m/2; j++) {
				t[i][m/2+j] = a[i][j];
			}
		}
		
		for(int i = 0; i < n/2; i++) {
			for(int j = m/2; j < m; j++) {
				t[n/2+i][j] = a[i][j];
			}
		}
		
		for(int i = n/2; i < n; i++) {
			for(int j = m/2; j < m; j++) {
				t[i][j-m/2] = a[i][j];
			}
		}
		
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				t[i-n/2][j] = a[i][j];
			}
		}
		
		a = t;
	}

	private static void four() {
		t = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				t[m - j - 1][i] = a[i][j];
			}
		}
		int tmp = n;
		n = m;
		m = tmp;

		a = t;

	}

	private static void three() {
		t = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				t[j][n - i - 1] = a[i][j];
			}
		}
		int tmp = n;
		n = m;
		m = tmp;

		a = t;

	}

	private static void two() {
		t = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				t[i][m - j - 1] = a[i][j];
			}
		}
		a = t;
	}

	private static void one() {
		t = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				t[n - i - 1][j] = a[i][j];
			}
		}
		a = t;
	}
}
