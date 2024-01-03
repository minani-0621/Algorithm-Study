import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input;
		input = scanner.next();
		int length = input.length();
		System.out.printf("%d", length);
	}
}
