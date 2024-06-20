package bj;

import java.io.*;
import java.util.*;

public class bj10974 {
	static int n;
	static int[] a,b;
	static boolean[] v;
	
	static StringBuilder sb = new StringBuilder();
	
	static void perm(int cnt) {
		//깊이가 n이면 StringBuilder에 b 배열에 저장된 순열을 추가함
		if(cnt == n) {
			for(int x : b) sb.append(x).append(" ");
			sb.append("\n");
			return;
		}
		//재귀
		for(int i = 0; i < n; i++) {
			if(v[i]) continue; //중복 체크
			//중복이 아니면
			v[i] = true; //true로 중복 방지
			b[cnt] = a[i]; //깊이 cnt를 index로 보고 순열 저장
			perm(cnt+1); //깊이 cnt를 하나 증가 시켜줌
			v[i] = false; //return하면 방문을 해제해 다음에 사용할 수 있도록 만들어줌
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n]; //1~N까지 수를 저장할 배열
		b = new int[n]; //만들어진 순열을 저장할 배열
		v = new boolean[n]; //중복 체크할 배열
		
		//1~N까지 수 입력
		for(int i = 0; i < n; i++) {
			a[i] = i+1;
		}
		
		perm(0);
		System.out.println(sb.toString());
	}

}
