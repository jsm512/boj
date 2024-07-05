package a0705.knapsack;

import java.io.*;
import java.util.*;

public class CoinGreedyMain {

	public static void main(String[] args) throws Exception{
		int N = 8;
		int[] coin = {6,4,1};
		int cnt = 0;
		
		for(int i = 0; i < coin.length; i++) {
			int c = N/coin[i];
			cnt += c;
			N -= c*coin[i];
		}
		System.out.println(cnt);
	}

}
