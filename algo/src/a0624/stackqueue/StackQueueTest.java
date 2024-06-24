package a0624.stackqueue;

import java.util.*;

public class StackQueueTest {
	
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("강호동");
		queue.offer("저팔계");
		queue.offer("손오공");
		queue.offer("사오정");
		queue.offer("홍길동");
		System.out.println(queue.peek() + " " + queue.size());
		System.out.println(queue.poll() + " " + queue.size());
		System.out.println(queue.poll() + " " + queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.poll() + " " + queue.size());
		System.out.println(queue);
		System.out.println();
		
//		Stack<String> stack = new Stack<>();
		//stack 대신 ArrayDeque 사용
		ArrayDeque<String> stack = new ArrayDeque<>();
		stack.push("강호동");
		stack.push("저팔계");
		stack.push("손오공");
		stack.push("사오정");
		stack.push("홍길동");
		System.out.println(stack.peek()+ " " + stack.size());
		System.out.println(stack.pop()+ " " + stack.size());
		System.out.println(stack.pop()+ " " + stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop()+ " " + stack.size());
		System.out.println(stack);
		System.out.println();
	}

}
