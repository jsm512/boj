package a0625sortkmp;

import java.io.*;
import java.util.*;

public class CountingSort {

	public static void main(String[] args) {
		int[] a = {0,4,1,3,1,2,4,1};
//		int max = a[0];
//		for(int i = 1; i < a.length; i++) {
//			if(max < a[i]) {
//				max = a[i];
//			}
//		}
		int m = Arrays.stream(a).max().getAsInt(); //배열에서 max 값 찾는 메소드
		System.out.println(m);
		int[] c = new int[m+1]; //누적을 시키는 배열
		int[] s = new int[a.length]; //sort 배열
		System.out.println(Arrays.toString(a));
		
		//a배열의 숫자들의 누적 개수
		for(int i = 0; i < a.length; i++) c[a[i]]++;
		System.out.println(Arrays.toString(c));

		for(int i = 1; i < c.length; i++) c[i] += c[i-1];
		System.out.println(Arrays.toString(c));
		
		for(int i = 0; i < a.length; i++) s[--c[a[i]]] = a[i];
		System.out.println(Arrays.toString(s));
	}
}
