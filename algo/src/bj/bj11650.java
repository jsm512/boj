package bj;

import java.io.*;
import java.util.*;

public class bj11650 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		Arrays.sort(a, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
////				if(o1[0] == o2[0]) return o1[1] - o2[1];
////				return o1[0] - o2[0]; 
//				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
//			}
//		});
		
		Arrays.sort(a, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		for(int[] i : a) {
			for(int x : i) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
