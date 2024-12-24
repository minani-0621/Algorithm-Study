import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int d1 = scanner.nextInt();
		int d2 = scanner.nextInt();
		
		double result;
		result = d1 * 2 + 2 * 3.141592 * d2;
		System.out.println(result);
	}
}
