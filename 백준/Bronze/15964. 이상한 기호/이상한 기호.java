import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		System.out.println((a + b) * (a - b));
	}
}
