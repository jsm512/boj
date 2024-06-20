package bj;

import java.io.*;
import java.util.*;

public class bj14888 {
	static int n;
	static int[] a;
	static int[] b = new int[4];

	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;

	static void perm(int depth, int num) {
		if (depth == n) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if(b[i] > 0) {
				//사용한 연산자 제거
				b[i]--;
				
				switch(i+1) {
				case 1:
					perm(depth+1, num + a[depth]);
					break;
				case 2:
					perm(depth+1, num - a[depth]);
					break;
				case 3:
					perm(depth+1, num * a[depth]);
					break;
				case 4:
					perm(depth+1, num / a[depth]);
					break;
				}
				//제거했던 연산자를 다시 추가
				b[i]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		a = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		perm(1, a[0]);

		System.out.println(Max);
		System.out.println(Min);
	}

}
