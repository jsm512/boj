package bj;

import java.io.*;
import java.util.*;

public class bj5397_ver2 {

	public static void main(String[] args)throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_5397.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch(c) {
                case '<' :
                    if(iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case '>' :
                    if(iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case '-' :
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default : 
                    iter.add(c);
            }
        }
			for(char c : list) sb.append(c);
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();
	}

}
