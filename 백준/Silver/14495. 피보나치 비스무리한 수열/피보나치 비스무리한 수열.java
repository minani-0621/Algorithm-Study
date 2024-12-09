import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static long[] array;
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		array = new long[n + 1];
		
		System.out.println(fib(n));
	}
	
	static long fib(int n) {
		if(n == 1 || n == 2 || n == 3) {
			return 1;
		}else if(array[n] != 0) {
			return array[n];
		}else {
			return array[n] = fib(n - 1) + fib(n - 3); 
		}
	}
}
