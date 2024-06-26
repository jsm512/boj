package bj;

import java.util.*;
import java.io.*;

public class bj1991 {
	static char[] data; // 노드 데이터를 저장하는 배열
    static int[] left;  // 왼쪽 자식 인덱스를 저장하는 배열
    static int[] right; // 오른쪽 자식 인덱스를 저장하는 배열
    
    // 전위 순회
    public static void preorder(int idx) {
        if (idx == -1) return;
        System.out.print(data[idx]);
        preorder(left[idx]);
        preorder(right[idx]);
    }
    
    // 중위 순회
    public static void inorder(int idx) {
        if (idx == -1) return;
        inorder(left[idx]);
        System.out.print(data[idx]);
        inorder(right[idx]);
    }
    
    // 후위 순회
    public static void postorder(int idx) {
        if (idx == -1) return;
        postorder(left[idx]);
        postorder(right[idx]);
        System.out.print(data[idx]);
    }
    
    public static void main(String[] args)throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        data = new char[n];
        left = new int[n];
        right = new int[n];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine().replace(" ", "");
            char parent = input.charAt(0);
            char leftChild = input.charAt(1);
            char rightChild = input.charAt(2);
            
            data[parent - 'A'] = parent;
            left[parent - 'A'] = (leftChild == '.') ? -1 : leftChild - 'A';
            right[parent - 'A'] = (rightChild == '.') ? -1 : rightChild - 'A';
        }
        
        // 전위 순회 출력
        preorder(0);
        System.out.println();
        
        // 중위 순회 출력
        inorder(0);
        System.out.println();
        
        // 후위 순회 출력
        postorder(0);
        System.out.println();
        
        br.close();
    }
}