import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		
		long answer = (a + b) * (a - b);
		
		System.out.println(answer);
	}
}
