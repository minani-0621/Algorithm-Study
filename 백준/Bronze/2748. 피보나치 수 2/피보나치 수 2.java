import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	static long array[];
	
	public static void main(String[] args) {
		n = scanner.nextInt();
		array = new long[n + 1];
		
		System.out.println(fib(n));
	}
	
	static long fib(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else if(array[n] != 0) {
			return array[n];
		}else {
			return array[n] =  fib(n - 1) + fib(n - 2);
		}
	}
}
