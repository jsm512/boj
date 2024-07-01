package a0701.graph;

import java.io.*;
import java.util.*;
public class GraphIntArray {

	public static void main(String[] args) {
//		int[] a = new int[1_065_877_500];
//		int[] a = new int[1_065_877_501]; //OutOfMemoryError
		int[][] a = new int[32_541][32_541];
//		int[][] a = new int[32_542][32_542];//OutOfMemoryError
		System.out.println(a);
		System.out.println();
		
		int[] ia = new int[3];
		ia[0] = 'A';
		System.out.println(Arrays.toString(ia));
		System.out.println();
		
		
		List<Integer>[] la = new List[3];
		System.out.println(Arrays.toString(la));
		for(int i = 0; i < la.length; i++) la[i] = new ArrayList<>();
		System.out.println(Arrays.toString(la));
		la[0].add(123); //16번째 줄 없으면 NullPointerException 
		System.out.println(Arrays.toString(la));
		
	}

}
