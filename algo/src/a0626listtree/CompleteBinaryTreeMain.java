package a0626listtree;

import java.io.*;
import java.util.*;

public class CompleteBinaryTreeMain {

	static class CompleteBinaryTree<T>{
		final int SIZE;
		Object[] nodes;
		int lastIndex;
		
		CompleteBinaryTree(int size) {
			SIZE = size;
			nodes = new Object[size+1]; //0번째 인덱스는 사용하지 않음
		}
		
		void add(T t) {
			if(lastIndex == SIZE) {
				System.out.println("포화상태!");
				return;
			}
			nodes[++lastIndex] = t;
		}
		
		void bfs(int i) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(i);
			while(!q.isEmpty()) {
				i = q.poll();
				System.out.print(nodes[i] + " ");
				if(i*2 + 0<= lastIndex) q.offer(i * 2 + 0); //left
				if(i*2 + 1<= lastIndex) q.offer(i * 2 + 1); //right
			}
		}
		
		//dfs
		void preOrder(int i) {
			System.out.print(nodes[i] + " ");
			if(i*2 + 0<= lastIndex) preOrder(i * 2 + 0);
			if(i*2 + 1<= lastIndex) preOrder(i * 2 + 1);			
		}
		void inOrder(int i) {
			if(i*2 + 0<= lastIndex) inOrder(i * 2 + 0);
			System.out.print(nodes[i] + " ");
			if(i*2 + 1<= lastIndex) inOrder(i * 2 + 1);			
		}
		void postOrder(int i) {
			if(i*2 + 0<= lastIndex) postOrder(i * 2 + 0);
			if(i*2 + 1<= lastIndex) postOrder(i * 2 + 1);			
			System.out.print(nodes[i] + " ");
		}
	}
	public static void main(String[] args) {
		int size = 12;
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		for(int i = 0; i < size; i++) {
			tree.add((char)('A'+i));
		}
		
		tree.bfs(1);
		System.out.println();
		tree.preOrder(1);
		System.out.println();
		tree.inOrder(1);
		System.out.println();		
		tree.postOrder(1);
		System.out.println();
		
	}

}
