package bj;

import java.io.*;
import java.util.*;

public class bj5397 {

	public static void main(String[] args)throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_5397.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			Stack<Character> ls = new Stack<>();
			Stack<Character> rs = new Stack<>();
			
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '<') {
					if(!ls.isEmpty()) {
						rs.push(ls.pop());
					}
				}
				else if(ch == '>') {
					if(!rs.isEmpty()) {
						ls.push(rs.pop());
					}
				}
				else if(ch == '-') {
					if(!ls.isEmpty()) ls.pop();
				}
				else {
					ls.push(ch);
				}
			}
			
			while(!ls.isEmpty()) rs.push(ls.pop());
			while(!rs.isEmpty()) {
				sb.append(rs.pop());
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();
	}

}
