package a0625sortkmp;

import java.util.*;

public class MergeSort {
	static int[] a = { 69, 10, 30, 2, 16, 8, 31, 22 };
	static int[] s;
	
	static void merge(int left, int mid, int right) {
		int i = left, j = mid + 1, k = left;
		while(i <= mid && j <= right) {
			if(a[i] <= a[j]) s[k++] = a[i++];
			else             s[k++] = a[j++];
		}
		if(i > mid) {
			for(int l = j; l <= right; l++) s[k++] = a[l];
		}
		else {
			for(int l = i; l <= mid; l++) s[k++] = a[l];
		}
		for(int l = left; l <= right; l++) a[l] = s[l];
	}
	static void mergesort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergesort(left, mid);
			mergesort(mid+1, right);
			merge(left,mid,right);
			System.out.println(Arrays.toString(a));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		s = new int[a.length];
		mergesort(0,a.length-1);
	}

}
