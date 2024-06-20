package a0619.recu;

public class RecursiveTest {
	static int fac(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * fac(n - 1);
		}
	}

	static int fibo(int n) {
		if (n <= 1)
			return n;
		return fibo(n - 1) + fibo(n - 2);
	}

	static void recur(int n) {
//		if (n > 0) {
//			recur(n - 1);
//			System.out.print(n + " ");
//			recur(n - 2);
//		}

		if (n <= 0) //if문에 종료 조건 ~ 
			return;
		//여기서부터 else  구문 반복 수행
		recur(n - 1);
		System.out.print(n + " ");
		recur(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fac(3));
		System.out.println(fibo(3));
		recur(3);
	}
}
