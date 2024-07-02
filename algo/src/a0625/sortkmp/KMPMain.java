package a0625.sortkmp;

import java.util.*;

public class KMPMain {

	public static void main(String[] args) {
		String T = "ABCDABCDABDE";
		String P =     "ABCDABD";
//		String T = "ABABABABCABABACA";
//		String P =          "ABABACA";
		int[] F = new int[P.length()];

		for (int t = 1, p = 0; t < P.length(); t++) {
			while (p > 0 && P.charAt(t) != P.charAt(p)) {
				p = F[p - 1];
			}
			if (P.charAt(t) == P.charAt(p)) {
				F[t] = ++p;
			}
		}
		System.out.println(Arrays.toString(F));

		List<Integer> ans = new ArrayList<>();
		for (int t = 1, p = 0; t < T.length(); t++) {
			while (p > 0 && T.charAt(t) != P.charAt(p)) {
				p = F[p - 1];
			}
			if (T.charAt(t) == P.charAt(p)) {
				if (p == P.length() - 1) {
					ans.add(t-p);
					p=F[p];
				} else {
					++p;
				}
			}
		}
		System.out.println(ans.size());
		System.out.println(ans);
	}
}
