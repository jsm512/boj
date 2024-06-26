package bj;
import java.io.*;
import java.util.*;

public class bj1406_ver2 {

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input_bj_1406.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext()) {
			iter.next(); //커서의 위치를 맨 뒤로 이동 시킴
		}
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char cmd = st.nextToken().charAt(0);
			if(cmd == 'P') {
				char ch = st.nextToken().charAt(0);
				iter.add(ch);
			}
			else if(cmd == 'L') {
				if(iter.hasPrevious()) iter.previous();
			}
			else if(cmd == 'D') {
				if(iter.hasNext()) iter.next();
			}
			else {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}
		
		for(char c : list) sb.append(c);
		System.out.println(sb);
		br.close();
		
	}

}
