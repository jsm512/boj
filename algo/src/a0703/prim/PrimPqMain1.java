package a0703.prim;
import java.io.*;

import java.util.*;
public class PrimPqMain1 {
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/a0703/prim/input_prim.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]>[] g = new List[N];
		for(int i = 0; i < N; i++) g[i] = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			for(int j=0; j<N; j++) {
				int c = sc.nextInt();
				if(c!=0) g[i].add(new int[]{j,c}); //인접정점번호, 비용
			}
		}
		boolean[] v = new boolean[N];
		int[] minEdge= new int[N];
		for(int i=0; i<N; i++) minEdge[i]=Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		int sum = 0, cnt = 0;
		minEdge[0]=0;
		pq.offer(new int[] {0,minEdge[0]}); //인접정점, 비용
		System.out.println(Arrays.toString(minEdge)); System.out.println();
		while(!pq.isEmpty()) {
			int [] vc = pq.poll();
			int min = vc[1];
			int minVertex = vc[0];
			if(v[minVertex]) continue;
			
			v[minVertex]=true;
			sum+=min;
			System.out.println(Arrays.toString(v));
			System.out.println("minVertex="+minVertex+" min="+min+" sum="+sum);
			if(cnt++==N-1) break;
			
			for(int[] j :g[minVertex]) {
				if(!v[j[0]] && minEdge[j[0]]>j[1]) {
							   minEdge[j[0]]=j[1];
							   pq.offer(new int[] {j[0],minEdge[j[0]]});
				}
			}
			System.out.println(Arrays.toString(minEdge));
			System.out.println();
		}
		System.out.println(sum);
		sc.close();
		
	}
}