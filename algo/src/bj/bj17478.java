package bj;

import java.io.*;

public class bj17478 {
	static int n;
	static String t = "____";
	static StringBuilder sb;
	//반복될 문구
	static String str1 = "\"재귀함수가 뭔가요?\"\n";
    static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    //처음 출력될 문구
	static String f = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String e = "라고 답변하였지.\n";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());	
		//첫번째 한번만 수행되는 문구
		sb.append(f).append("\n");
		//재귀 실행
		sol(0, "");
		System.out.println(sb.toString());
		
		br.close();
		
	}
	
	static void sol(int depth, String tap) {
		
		if(depth == n) {
			sb.append(tap).append(str1);
			sb.append(tap).append(str5);
			sb.append(tap).append(e);
			return;
		}
		
		else {
			sb.append(tap).append(str1);
			sb.append(tap).append(str2);
			sb.append(tap).append(str3);
			sb.append(tap).append(str4);
			sol(depth+1,tap+t);
			sb.append(tap).append(e);
		}
	}

}
