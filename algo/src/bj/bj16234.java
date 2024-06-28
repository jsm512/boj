package bj;

import java.io.*;
import java.util.*;

public class bj16234 {
	static int N, L, R;
	static int[][] a;
	static int answer = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		a = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < N-1; i++) {
				for(int j = 0; j < N-1; j++) {
					if(L <= Math.abs(a[i][j] - a[i][j+1]) 
							&& Math.abs(a[i][j] - a[i][j+1])<= R) {
						cnt++;
						sum += Math.abs(a[i][j] - a[i][j+1]);
					}
					if(L <= Math.abs(a[j][i] - a[j+1][i])
							&& Math.abs(a[j][i] - a[j+1][i]) <= R) {
						cnt++;
						sum += Math.abs(a[j][i] - a[j+1][i]);
					}
				}
			}
			System.out.println(cnt);
			if(cnt == 0) {
				System.out.println(answer);
				break;
			}
			else { //인구이동이 가능
				answer++;
				int split = sum / cnt;
				for(int i = 0; i < N-1; i++) {
					for(int j = 0; j < N-1; j++) {
						if(L <= Math.abs(a[i][j] - a[i][j+1]) 
								&& Math.abs(a[i][j] - a[i][j+1])<= R) {
							a[i][j] = split;
							a[i][j+1] = split;
						}
						if(L <= Math.abs(a[j][i] - a[j+1][i])
								&& Math.abs(a[j][i] - a[j+1][i]) <= R) {
							a[j][i] = split;
							a[j+1][i] = split;
						}
					}
				}
			}
		}
	}
}
