package bj;
import java.io.*;
import java.util.*;

public class bj1406 {

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1406.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> ls = new Stack<>();
		Stack<Character> rs = new Stack<>();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			ls.push(str.charAt(i));
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char cmd = st.nextToken().charAt(0);
			if(cmd == 'P') {
				char ch = st.nextToken().charAt(0);
				ls.push(ch);
			}
			else if(cmd == 'L') {
				if(!ls.isEmpty()) rs.push(ls.pop());
			}
			else if(cmd == 'D') {
				if(!rs.isEmpty()) ls.push(rs.pop());
			}
			else {
				if(!ls.isEmpty()) ls.pop();
			}
		}
		
		while(!ls.isEmpty()) rs.push(ls.pop());
		while(!rs.isEmpty()) sb.append(rs.pop());
		System.out.println(sb.toString());

//		LinkedList<Character> list = new LinkedList<>();
//		String str = br.readLine();
//		
//		for(int i = 0; i < str.length(); i++) {
//			list.add(str.charAt(i));
//		}
//		
//		int cur = list.size();
//		int m = Integer.parseInt(br.readLine());
//		
//		for(int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			char cmd = st.nextToken().charAt(0);
//			if(cmd == 'P') { 
//				char ch = st.nextToken().charAt(0);
//				list.add(cur++, ch);
//			}
//			else if(cmd == 'L') {
//				if(cur > 0) cur--;
//			}
//			else if(cmd == 'D') {
//				if(cur < list.size()) cur++;
//			}
//			else {
//				if(cur > 0) list.remove(--cur);
//			}
//		}
//		
//		for(char c : list) sb.append(c);
//		System.out.println(sb);
//		br.close();
		
	}

}
