package bj;

import java.io.*;
import java.util.*;

public class bj11000 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] a = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 2; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(a, (o1,o2) -> Integer.compare(o1[0], o2[0]));
		
//		System.out.println(Arrays.deepToString(a));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(a[0][1]);
		for(int i = 1; i < a.length; i++) {
			if(pq.peek() <= a[i][0]) {
				pq.poll();
			}
			pq.offer(a[i][1]);
		}
		System.out.println(pq.size());
	}
}
