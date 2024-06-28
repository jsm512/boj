package bj;

import java.io.*;
import java.util.*;

public class bj2580 {
	static int[][] a = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	static boolean flag = false;

	static boolean check(int x, int y, int num) {
		for (int i = 0; i < 9; i++) { // 행 검사
			if (a[x][i] == num)
				return false;
		}
		for (int i = 0; i < 9; i++) {// 열 검사
			if (a[i][y] == num)
				return false;
		}

		// 3*3 배열의 row, col 값 초기화
		int row = (x / 3) * 3;
		int col = (y / 3) * 3;

		// 3*3배열 검사
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (a[i][j] == num)
					return false;
			}
		}

		return true;
	}

	static void sol(int x, int y) {
		if (!flag) {
			// 해당 행에 모든 숫자가 채워져 있으면 행을 한칸 옮김
			if (y == 9) {
				sol(x + 1, 0);
				return;
			}
			// 마지막 행까지 숫자를 채웠으면 출력
			if (x == 9) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						sb.append(a[i][j]).append(" ");
					}
					sb.append("\n");
				}
				flag = true;
				return;
			}
			// 빈칸을 발견했음
			if (a[x][y] == 0) {
				for (int i = 0; i < 9; i++) {
					if (check(x, y, i + 1)) { // 행, 열, 3*3 배열을 확인
						a[x][y] = i + 1; // i+1의 값이 들어갈 수 있다면 추가해줌
						sol(x, y + 1); // 열을 한칸 옮겨서 진행
					}
				}
				a[x][y] = 0;
				return;
			}

			sol(x, y + 1); // 열 한칸 옮김
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sol(0, 0);
		System.out.print(sb.toString());

	}

}
