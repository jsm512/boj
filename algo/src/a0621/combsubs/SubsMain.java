package a0621.combsubs;

import java.io.*;
import java.util.*;

public class SubsMain {

	static int N = 3, C = 0;
	static int[] a = { 1, 2, 3, 4, 5 };
//	static boolean[] v = new boolean[N];

	static void subs(int cnt, String str) {	
		if (cnt == N) {
			System.out.println(str);
			C++;
			return;
		}
		subs(cnt + 1, str+a[cnt]); //선택
		subs(cnt + 1, str); //비선택
	}
	public static void main(String[] args) throws Exception {
		C = 0;
		subs(0,"");
		System.out.println(C);
	}
}
