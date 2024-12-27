import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scanner.nextInt();
		long result = 1;
		
		for(int i = 1; i <= N; i++) {
			result *= i;
		}
		
		System.out.println(result);
	}
}
