package bj;

import java.io.*;

public class bj11729 {
	static int k = 0;
	static StringBuilder sb;
	static void hanoi(int n, int from, int mid, int to) {
		if (n == 0)
			return;
		hanoi(n - 1, from, to, mid);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n - 1, mid, from, to);
		k++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		hanoi(n,1, 2, 3);
		
		System.out.println(k);
		System.out.println(sb.toString());
		
		br.close();
	}

}
