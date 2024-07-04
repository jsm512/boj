package bj;

import java.io.*;
import java.util.*;
/*
 * ex) N = 3
 * 1(5) -> 2(5) -> 3(4)
 *  ↓       ↓       ↓
 * 4(3) -> 5(9) -> 6(1)
 *  ↓       ↓       ↓
 * 7(3) -> 8(2) -> 9(7)
 * 
 * 간선의 갯수 = (N-1 * N-1)*2 + 2N-1;
 */
public class bj4485_PQ {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4485.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			List<int[]>[] g = new List[N*N+1];
			for(int i = 0; i <= N*N; i++) {
				g[i] = new ArrayList<>();
			}
			
			int E = (N-1 * N-1) * 2 + 2*N-1;
			int from = 1;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i % N == 0) { //간선 1개
						
					}
					else if(j % N == 0) { //간선 1개
						
					}
					else { //간선이 2개 존재
						
					}
				}
			}
			
		}
	}

}
