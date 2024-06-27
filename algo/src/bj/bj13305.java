package bj;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class bj13305 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		BigInteger[] road_length = new BigInteger[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < road_length.length; i++) {
			road_length[i] = new BigInteger(st.nextToken());
		}
		
		BigInteger[] fuel = new BigInteger[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < fuel.length; i++) {
			fuel[i] = new BigInteger(st.nextToken());
		}
		
		int idx = 0;
		BigInteger ans = BigInteger.ZERO;
		BigInteger current = fuel[0];
		for(int i = 0; i < n-1; i++) {
				if(current.compareTo(fuel[i]) > 0) {
					current = fuel[i];
				}
				ans = ans.add(current.multiply(road_length[i]));
		}
		System.out.println(ans);
	}

}
