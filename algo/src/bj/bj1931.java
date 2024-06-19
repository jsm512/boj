package bj;

import java.io.*;
import java.util.*;

public class bj1931 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n][2];
			
			//2차원 배열 Input 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//2차원 배열 정렬 y(끝나는 시간) 기준으로 정렬
			/*
			 * 시작 시간을 기준으로 정렬하면 회의 시간이 길어 다른 회의를 진행하지 못하는 경우가 생김 -> 그리디 X
			 * 가능한 회의 중 끝ㄴㅏ는 시간이 빠를수록 뒤에 더 많은 회의를 진행할 수 있음
			 */
			Arrays.sort(a, (o1, o2) -> {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			});
			
			//정렬된 2차원 배열 출력
//			System.out.println(Arrays.deepToString(a));
			
			
			//가장 빠른시간에 끝나는 강의 끝나는 시간을 저장
			int tmp = a[0][1];
			int ans = 1; //첫번째로 끝나는 강의를 포함
			for(int i = 1; i < n; i++) {
				if(tmp <= a[i][0]) {
					tmp = a[i][1];
					ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
//			System.out.println(ans);
		}
		System.out.println(sb.toString());
		br.close();
	}

}
