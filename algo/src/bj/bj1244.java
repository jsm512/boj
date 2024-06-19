package bj;

import java.io.*;
import java.util.*;

public class bj1244 {
	/*
	 * 스위치 켜짐 1, 꺼짐 0 
	 * 남학생 1, 여학생 2 
	 * 남학생 - 배수 idx의 스위치 상태 변경 
	 * 여학생 - 받은 번호를 기준으로 대칭이면 상태
	 * 변경
	 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int stu = Integer.parseInt(br.readLine());

		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			if (gen == 1) {
				men(a, target);
			} else if (gen == 2) {
				women(a, target);
			}
		}

		for(int i = 0; i < n; i++) {
			System.out.print(a[i]+ " ");
			if((i+1) % 20 == 0) 
				System.out.println();
		}

	}

	public static void men(int[] a, int idx) {
		for (int i = idx - 1; i < a.length; i += idx) {
			a[i] = (a[i] == 0) ? 1 : 0;
		}
	}

	public static void women(int[] a, int idx) {
		int left = idx - 2;
		int right = idx;

		//주어진 idx 스위치 변경
		a[idx - 1] = (a[idx - 1] == 0) ? 1 : 0;

		//대칭 확인 후 선택적 스위치 변경
		//범위 체크
		while (left >= 0 && right < a.length && a[left] == a[right]) {
				a[left] = (a[left] == 0) ? 1 : 0;
				a[right] = (a[right] == 0) ? 1 : 0;
				left--;
				right++;
		}
	}

}
