package a0619.recu;

import java.io.InputStreamReader;
import java.io.*;

public class HanoiTest {
	static void hanoi(int n, int from, int mid, int to) {
		if (n == 0)
			return;
		hanoi(n - 1, from, to, mid);
		System.out.println(n + ": " + from + "->" + to);
		hanoi(n - 1, mid, from, to);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 2, 3);

	}

}
