import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		long k = scanner.nextInt();
		long a = scanner.nextInt();
		long b = scanner.nextInt();
		long c = scanner.nextInt();
		long d = scanner.nextInt();
		
		if(a * k + b == c * k + d) {
			System.out.println("Yes " + (a * k + b));
		}else {
			System.out.println("No");
		}
	}
}
