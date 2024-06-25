package bj;

import java.io.*;
import java.util.*;

public class bj1786 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();
		
		int[] F = new int[P.length()];
		for (int t = 1, p = 0; t < P.length(); t++) {
			while (p > 0 && P.charAt(t) != P.charAt(p)) {
				p = F[p - 1];
			}
			if (P.charAt(t) == P.charAt(p)) {
				F[t] = ++p;
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int t = 0, p = 0; t < T.length(); t++) {
			while (p > 0 && T.charAt(t) != P.charAt(p)) {
				p = F[p - 1];
			}
			if (T.charAt(t) == P.charAt(p)) {
				if (p == P.length() - 1) {
					ans.add(t-p+1);
					p=F[p];
				} else {
					++p;
				}
			}
		}
		System.out.println(ans.size());
		for(int x : ans) {
			System.out.println(x);
		}
	}

}
