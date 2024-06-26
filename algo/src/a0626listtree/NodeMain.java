package a0626listtree;

import java.io.*;
import java.util.*;

public class NodeMain {
	
	static int n;
	static Node[] g;
	
	static class Node {
		int data; //노드 그래프의 정점 번호
		Node next; //다음 정점의 정보를 가지고 있음
		Node(int vertex, Node link){
			this.data = vertex;
			this.next = link;
		}
		@Override
		public String toString() {
			return ""+(char)(data + 'A')+data+ "->" + next;
		}
	}
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_graph.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		g = new Node[n];
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from] = new Node(to,g[from]);
//			g[to] = new Node(from,g[to]);
		}
		
//		for(Node a : g)System.out.println(a);
//		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.print(""+(char)(i + 'A')+i+ ": ");
			for(Node j=g[i]; j != null; j = j.next) {
				System.out.print(""+(char)(j.data + 'A')+j.data+ "->");
			}
			System.out.println("null");
		}
		System.out.println();
		br.close();
	}
/*
....A0     
.../.\
..B1.C2
./.\./
D3..E4 
..\.|
...F5-G6
 */
}
