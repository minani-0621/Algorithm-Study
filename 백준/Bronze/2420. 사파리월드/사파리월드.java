import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		long n = scanner.nextInt();
		long m = scanner.nextInt();
		long result;
		
		result = Math.abs(n - m);
		System.out.println(result);
	}
}
