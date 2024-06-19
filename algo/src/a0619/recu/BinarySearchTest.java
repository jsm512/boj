package a0619.recu;

import java.io.*;
import java.util.*;

public class BinarySearchTest {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input_bj_0000.txt")); //res에 폴더에 input 값을 저장하면 직접 input 안해도 자동으로 읽어 줌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N;  i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(a));
			
			int key = Integer.parseInt(br.readLine());
			//binarySearch()메소드는 배열에 찾는 값이 존재하지 않으면 -(삽입 포인트) - 1 의 값을 반환함
			/*
			 * 7
			 * 15 27 39 77 92 108 121
			 * 150
			 * 의 input을 넣었을 때
			 * 150의 값의 삽입 포인트는 121 뒤 idx로는 7의 위치에 삽입 포인트가 결정이 됨
			 * 삽입 포인트 값 -(삽입 포인트)에 -1을 더한 값인 -8을 return 하게 됨
			 */
			int ans = Arrays.binarySearch(a, key); 
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
		
//		System.out.print("요솟수: ");
//		int num = Integer.parseInt(br.readLine());
//		int[] x = new int[num];
//		
//		System.out.println("오름차순으로 입력하세요.");
//		
//		System.out.print("x[0]: ");
//		x[0] = Integer.parseInt(br.readLine());
//		
//		for(int i = 1; i < num; i++) {
//			do {
//				System.out.print("x[" + i + "]: ");
//				x[i] = Integer.parseInt(br.readLine());
//			}while(x[i] < x[i-1]);
//		}
//		
//		System.out.print("검색할 값: ");
//		int ky = Integer.parseInt(br.readLine());
//		
//		int idx = Arrays.binarySearch(x, ky);
//		
//		if(idx < 0) {
//			System.out.println("그 값의 요소가 없습니다");
//		}
//		else {
//			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
//		}
	}

}
