package bj;

import java.io.*;
import java.util.*;

public class bj1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] s = new String[n];
		
		for(int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		
//		Arrays.sort(s, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				if(o1.length() == o2.length()) return o1.compareTo(o2);
//				return o1.length() - o2.length();
//			}
//		});
		
		Arrays.sort(s,(o1,o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
//		System.out.println(Arrays.toString(s));
		
		sb = new StringBuilder();
		sb.append(s[0]).append("\n");
		for(int i = 1; i < s.length; i++) {
			if(s[i].equals(s[i-1])) continue;
			sb.append(s[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
