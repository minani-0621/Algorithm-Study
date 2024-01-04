import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static long n;
	static long list[];
	static int i = 0;
	static int count = 0;
	
	public static void main(String[] args) {
		n = scanner.nextLong();
		long calc = n;
		while(calc > 0) {
			calc = calc / 2;
			count++;
		}
		
		list = new long[count];
		
		while(n > 0) {
			long r = n % 2;
			n = n / 2;
			list[i] = r;
			i++;
		}
		
		int length = list.length;
		
		for(int i = length - 1; i >= 0; i--) {
			System.out.printf("%d", list[i]);
		}
	}
}
