package bj;

import java.io.*;
import java.util.*;

public class bj15686 {
	static int N, M;
	static int[][] a;
	static boolean[] v;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> person = new ArrayList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j] == 1) person.add(new int[] {i,j}); //사람 위치 저장
				if(a[i][j] == 2) chicken.add(new int[] {i,j});//치킨 위치 저장
			}
		}
		v = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(ans);
		/*
		 * 1. 폐업 시켜야되는 치킨집 선택 => 조합
		 * 2. 선택된 치킨집 폐업 시키고(2 -> 1로 바꿈)
		 * 3. 집에서 가장 가까운 치킨집 찾기
		 * 4. 어떤 치킨집이 폐업 됐을 때 최소가 되는지 확인
		 */
	}
	static void dfs(int depth, int idx) {
		if(depth == M) { //살려야되는 치킨집
			int res = 0;
			for(int i = 0; i < person.size(); i++) {
				int cnt = Integer.MAX_VALUE;
				for(int j = 0; j < chicken.size(); j++) {
					if(v[j]) {
						int dist = Math.abs(person.get(i)[0] - chicken.get(j)[0])
								+Math.abs(person.get(i)[1] - chicken.get(j)[1]);
						cnt = Math.min(cnt, dist);
					}
					res += cnt;
				}
				ans = Math.min(res, ans);
			}
			
			return;
		}
		for(int i = idx; i < chicken.size(); i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(depth+1, i+1);
			v[i] = false;
		}
		
	}
}
